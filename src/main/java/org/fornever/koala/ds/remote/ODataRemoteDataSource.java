package org.fornever.koala.ds.remote;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.http.impl.client.BasicCookieStore;
import org.fornever.koala.blurprints.IDataSource;
import org.fornever.koala.exception.AuthenticationFailedException;
import org.fornever.koala.exception.NotFoundException;
import org.fornever.koala.type.Condition;
import org.fornever.koala.type.Row;
import org.fornever.koala.type.SearchParameter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

public class ODataRemoteDataSource implements IDataSource {

	private static final String X_CSRF_TOKEN = "x-csrf-token";

	@Inject
	@Named("odata:endpoint")
	private String endpoint;

	@Inject
	@Named("odata:username")
	private String username;

	@Inject
	@Named("odata:password")
	private String password;

	private Map<String, String> headers = new HashMap<String, String>() {

		private static final long serialVersionUID = -1242392396219337858L;

		// default headers

		{
			put(X_CSRF_TOKEN, "fetch");
			put("Content-Type", "application/json");
			put("Accept", "application/json");
			put("Accept-Language", "zh");
		}

	};

	public ODataRemoteDataSource() {
	}

	public ODataRemoteDataSource(String collectionURI, String username, String password) {
		super();
		this.endpoint = collectionURI;
		this.username = username;
		this.password = password;
		Unirest.setHttpClient(
				org.apache.http.impl.client.HttpClients.custom().setDefaultCookieStore(new BasicCookieStore()).build());
	}

	@Override
	public Object fromRowToKey(Row row) throws Throwable {
		return row.get("ObjectID");
	}

	private void _fetchCSRFToken() throws Throwable {

		HttpResponse<String> res = Unirest.head(this.endpoint).headers(this.headers)
				.basicAuth(this.username, this.password).asString();

		// server will response 405 Method Not Allowed

		this._processResponse(res);

		if (this.headers.get(X_CSRF_TOKEN) == null || this.headers.get(X_CSRF_TOKEN) == "fetch") {
			throw new Exception("Can not fetch csrf token !");
		}

	}

	private String _formatObjectURI(Object key) {
		return String.format("%s('%s')", this.endpoint, key.toString());
	}

	private Map<String, Object> _formatQueryParametersURI(SearchParameter param) {
		Map<String, Object> rt = new HashMap<>();
		if (param.getFieldConditions().size() > 0) {
			String filter = String.join(" and ",
					param.getFieldConditions().entrySet().stream().map(this::_mappingConditionToExpr).filter(s -> {
						if (s == null || s.isEmpty()) {
							return false;
						}
						return false;
					}).collect(Collectors.toList()));
			rt.put("$filter", filter);
		}

		rt.put("$top", param.getSize());
		rt.put("$skip", (param.getPage() - 1) * param.getSize());

		return rt;

	}

	private String _mappingConditionToExpr(Entry<String, List<Condition>> entry) {
		String rt = null;
		String field = entry.getKey();
		List<Condition> conditions = entry.getValue();
		// basic support
		if (conditions.size() == 1) {
			Condition condition = conditions.get(0);
			switch (condition.getOperator()) {
			case EQUAL:
				rt = String.format("%s eq '%s'", field, condition.getValue().toString());
				break;
			case NOT_EUQAL:
				rt = String.format("%s ne '%s'", field, condition.getValue().toString());
			default:
				rt = "";
				break;
			}

		} else {
			rt = "";
		}

		return rt;
	}

	private Row _mappingJSONObjectToRow(JSONObject obj) {
		Row row = new Row();
		row.putAll(obj);
		return row;
	}

	private Row _mappingJsonToRow(String json) {
		JSONObject results = JSON.parseObject(json).getJSONObject("d").getJSONObject("results");
		return this._mappingJSONObjectToRow(results);
	}

	private List<Row> _mappingJsonToRowList(String json) {
		List<Row> rt = new LinkedList<>();
		JSONObject obj = JSON.parseObject(json);
		JSONArray results = obj.getJSONObject("d").getJSONArray("results");
		for (int i = 0; i < results.size(); i++) {
			rt.add(this._mappingJSONObjectToRow(results.getJSONObject(i)));
		}

		return rt;
	}

	private void _processResponse(HttpResponse<String> res) throws Throwable {
		// > set CSRF token
		String token = res.getHeaders().getFirst(X_CSRF_TOKEN);
		if (token != null) {
			this.headers.put(X_CSRF_TOKEN, token);
		}
		// < set CSRF token
	}

	@Override
	public Row create(Row row) throws Throwable {

		String uri = this.endpoint;

		HttpResponse<String> res = Unirest.post(uri).headers(this.headers).basicAuth(this.username, this.password)
				.body(JSON.toJSONString(row)).asString();
		Integer status = res.getStatus();

		switch (status) {

		case 200:
		case 201:
		case 202:
		case 204:
			// Retrieve new data
			return this._mappingJsonToRow(res.getBody());

		case 401:

			throw new AuthenticationFailedException();

		case 403:

			if (res.getHeaders().getFirst(X_CSRF_TOKEN).equals("Required")) {
				this._fetchCSRFToken();
				// retry
				return this.create(row);

			} else {

				throw new Error(res.getBody());
			}

		case 404:

			// not found

			throw new NotFoundException();

		case 500:

			throw new Error(res.getBody());

		default:

			break;
		}

		return null;
	}

	@Override
	public Boolean delete(Object key) throws Throwable {
		String uri = this._formatObjectURI(key);

		HttpResponse<String> res = Unirest.delete(uri).headers(this.headers).basicAuth(this.username, this.password)
				.asString();

		Integer status = res.getStatus();

		switch (status) {

		case 200:
		case 201:
		case 202:
		case 204:

			return true;

		case 401:

			throw new AuthenticationFailedException();

		case 403:

			if (res.getHeaders().getFirst(X_CSRF_TOKEN).equals("Required")) {
				this._fetchCSRFToken();
				// retry
				return this.delete(key);

			} else {

				throw new Error(res.getBody());
			}

		case 404:

			// not found

			throw new NotFoundException();

		case 500:

			throw new Error(res.getBody());

		default:

			break;
		}

		return false;
	}

	@Override
	public List<Row> find(SearchParameter param) throws Throwable {

		List<Row> rt = new LinkedList<>();
		String uri = this.endpoint;

		HttpResponse<String> res = Unirest.get(uri).queryString(this._formatQueryParametersURI(param))
				.headers(this.headers).basicAuth(username, password).asString();

		Integer status = res.getStatus();

		switch (status) {

		case 200:

			return this._mappingJsonToRowList(res.getBody());

		case 400:

			throw new Error(res.getBody());

		case 401:

			throw new AuthenticationFailedException();

		case 403:

			if (res.getHeaders().getFirst(X_CSRF_TOKEN).equals("Required")) {
				this._fetchCSRFToken();
				// retry
				return this.find(param);
			} else {
				throw new Error(res.getBody());
			}

		case 404:

			// not found

			throw new NotFoundException();

		case 500:

			throw new Error(res.getBody());

		default:

			break;
		}

		return rt;

	}

	public String getPassword() {
		return password;
	}

	public String getURI() {
		return endpoint;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public Row retrieve(Object key) throws Throwable {

		String uri = this._formatObjectURI(key);

		HttpResponse<String> res = Unirest.get(uri).headers(this.headers).basicAuth(this.username, this.password)
				.asString();

		Integer status = res.getStatus();

		this._processResponse(res);

		switch (status) {

		case 200:

			return this._mappingJsonToRow(res.getBody());

		case 401:

			throw new AuthenticationFailedException();

		case 403:

			if (res.getHeaders().getFirst(X_CSRF_TOKEN).equals("Required")) {
				this._fetchCSRFToken();
				// retry
				return this.retrieve(key);

			} else {
				throw new Error(res.getBody());
			}

		case 404:

			// not found

			throw new NotFoundException();

		case 500:

			throw new Error(res.getBody());

		default:

			break;
		}

		return null;

	}

	public void setCollectionURI(String collectionURI) {
		this.endpoint = collectionURI;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public Row update(Row row) throws Throwable {

		Object key = this.fromRowToKey(row);

		String uri = this._formatObjectURI(key);

		HttpResponse<String> res = Unirest.patch(uri).headers(this.headers).basicAuth(this.username, this.password)
				.body(JSON.toJSONString(row)).asString();

		Integer status = res.getStatus();

		switch (status) {

		case 200:
		case 201:
		case 202:
		case 204:
			// Retrieve new data
			return this.retrieve(key);

		case 401:

			throw new AuthenticationFailedException();

		case 403:

			if (res.getHeaders().getFirst(X_CSRF_TOKEN).equals("Required")) {
				this._fetchCSRFToken();
				// retry
				return this.update(row);

			} else {

				throw new Error(res.getBody());
			}

		case 404:

			// not found

			throw new NotFoundException();

		case 500:

			throw new Error(res.getBody());

		default:

			break;
		}

		return null;
	}

}
