package org.fornever.koala.local;

import org.dizitart.no2.Document;
import org.dizitart.no2.NitriteCollection;
import org.dizitart.no2.NitriteId;
import org.fornever.koala.blurprints.IDataSource;
import org.fornever.koala.type.Row;

public class NitriteLocalDataSource implements IDataSource {

	private NitriteCollection collection;

	public NitriteLocalDataSource(NitriteCollection collection) {
		super();
		this.collection = collection;
	}

	@Override
	public Row create(Row row) {
		Document doc = new Document(row);
		return mapDocumentToRow(this.collection.getById(this.collection.insert(doc).iterator().next()));
	}

	@Override
	public Boolean delete(Object key) {
		return this.collection.remove(this.collection.getById(mapObjectToKey(key))).getAffectedCount() > 0;
	}

	private Row mapDocumentToRow(Document doc) {
		if (doc != null) {
			Row rt = new Row();
			rt.putAll(doc);
			return rt;
		} else {
			return null;
		}
	}

	private NitriteId mapObjectToKey(Object key) {
		return NitriteId.createId(Long.valueOf(key.toString()));
	}

	@Override
	public Row retrieve(Object key) {
		return this.mapDocumentToRow(this.collection.getById(mapObjectToKey(key)));
	}

	@Override
	public Row update(Object key, Row update) {
		Document doc = this.collection.getById(NitriteId.createId(Long.valueOf(key.toString())));
		if (doc != null) {
			doc.putAll(update);
			this.collection.update(doc);
			return this.mapDocumentToRow(this.collection.getById(NitriteId.createId(Long.valueOf(key.toString()))));
		}
		return null;
	}

}
