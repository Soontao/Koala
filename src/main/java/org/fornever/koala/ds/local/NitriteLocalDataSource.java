package org.fornever.koala.ds.local;

import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;

import org.dizitart.no2.Document;
import org.dizitart.no2.Filter;
import org.dizitart.no2.FindOptions;
import org.dizitart.no2.NitriteCollection;
import org.dizitart.no2.NitriteId;
import org.dizitart.no2.SortOrder;
import org.dizitart.no2.filters.Filters;
import org.fornever.koala.blurprints.IDataSource;
import org.fornever.koala.type.Condition;
import org.fornever.koala.type.OrderField;
import org.fornever.koala.type.Row;
import org.fornever.koala.type.SearchParameter;
import org.fornever.koala.type.enums.OrderType;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class NitriteLocalDataSource implements IDataSource {

	private NitriteCollection collection;

	@Inject
	public NitriteLocalDataSource(@Named("nitrite:collection") NitriteCollection collection) {
		super();
		this.collection = collection;
	}

	@Override
	public Object fromRowToKey(Row row) throws Throwable {
		return row.get("_id");
	}

	@Override
	public Row create(Row row) {
		Document doc = new Document(row);
		return _mapDocumentToRow(this.collection.getById(this.collection.insert(doc).iterator().next()));
	}

	@Override
	public Boolean delete(Object key) {
		return this.collection.remove(this.collection.getById(_mapObjectToKey(key))).getAffectedCount() > 0;
	}

	private Row _mapDocumentToRow(Document doc) {
		if (doc != null) {
			Row rt = new Row();
			rt.putAll(doc);
			return rt;
		} else {
			return null;
		}
	}

	private NitriteId _mapObjectToKey(Object key) {
		return NitriteId.createId(Long.valueOf(key.toString()));
	}

	@Override
	public List<Row> find(SearchParameter param) throws Throwable {
		FindOptions options = FindOptions.limit(param.getPage(), param.getSize());
		List<OrderField> orders = param.getOrders();

		if (!orders.isEmpty()) {
			OrderField of = orders.get(0);
			options = FindOptions.sort(of.getField(),
					of.getType() == OrderType.asc ? SortOrder.Ascending : SortOrder.Descending);
			options.thenLimit(param.getPage(), param.getSize());
		}

		List<Filter> fs = param.getFieldConditions().entrySet().stream().map(this::_mapFieldConditionsToFilter)
				.filter(filter -> Objects.nonNull(filter)).collect(Collectors.toList());
		Filter f = Filters.and(fs.toArray(new Filter[] {}));
		return this.collection.find(f).toList().stream().map(this::_mapDocumentToRow).collect(Collectors.toList());
	}

	public Filter _mapFieldConditionsToFilter(Entry<String, List<Condition>> e) {

		String field = e.getKey();
		List<Condition> cs = e.getValue();

		if (!cs.isEmpty()) {

			if (cs.size() == 1) {
				Condition c = cs.stream().findFirst().get();
				switch (c.getOperator()) {
				case EQUAL:
					return Filters.eq(field, c.getValue());
				case NOT_EUQAL:
					return Filters.not(Filters.eq(field, c.getValue()));
				default:
					break;
				}

			} else if (cs.size() > 1) {

			}

		}

		return null;
	}

	@Override
	public Row retrieve(Object key) {
		return this._mapDocumentToRow(this.collection.getById(_mapObjectToKey(key)));
	}

	@Override
	public Row update(Row update) throws NumberFormatException, Throwable {
		NitriteId key = NitriteId.createId(Long.valueOf(this.fromRowToKey(update).toString()));
		Document doc = this.collection.getById(key);
		if (doc != null) {
			doc.putAll(update);
			this.collection.update(doc);
			return this._mapDocumentToRow(this.collection.getById(key));
		}
		return null;
	}

}
