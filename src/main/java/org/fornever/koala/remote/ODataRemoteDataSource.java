package org.fornever.koala.remote;

import java.util.List;

import org.fornever.koala.blurprints.IDataSource;
import org.fornever.koala.type.Row;
import org.fornever.koala.type.SearchParameter;

public class ODataRemoteDataSource implements IDataSource {

	public ODataRemoteDataSource(String collectionURI, String username, String password) {
		super();
		this.collectionURI = collectionURI;
		this.username = username;
		this.password = password;
	}

	private String collectionURI;

	private String username;

	private String password;

	public String getCollectionURI() {
		return collectionURI;
	}

	public void setCollectionURI(String collectionURI) {
		this.collectionURI = collectionURI;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public List<Row> find(SearchParameter param) {
		return null;
	}

	@Override
	public Row retrive(Object key) {
		return null;
	}

	@Override
	public Boolean delete(Object key) {
		return null;
	}

	@Override
	public Row create(Row row) {
		return null;
	}

	@Override
	public Row update(Object key, Row update) {
		return null;
	}

}
