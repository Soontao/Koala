package org.fornever.koala.ds.local;

import org.dizitart.no2.Document;
import org.dizitart.no2.NitriteCollection;
import org.dizitart.no2.NitriteId;
import org.fornever.koala.blurprints.IDataSource;
import org.fornever.koala.type.Row;

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
