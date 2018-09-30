package org.fornever.koala.local;

import java.util.Map;

import org.dizitart.no2.Document;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteCollection;
import org.dizitart.no2.NitriteId;
import org.dizitart.no2.WriteResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class NitritelTest {

	private Nitrite db;
	private NitriteCollection collection;

	private ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setUp() throws Exception {
		this.db = Nitrite.builder().openOrCreate();
		this.collection = this.db.getCollection("buildings");
	}

	@After
	public void tearDown() throws Exception {
		this.db.close();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testCreate() {
		Document doc = new Document();
		doc.putAll(mapper.convertValue(new Building("Building1", "四川成都", 123), Map.class));
		assert this.collection.insert(doc).getAffectedCount() > 0;
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testDelete() {
		Document doc = new Document();
		doc.putAll(mapper.convertValue(new Building("Building3", "四川成都32", 123), Map.class));
		WriteResult r = this.collection.insert(doc);
		assert r.getAffectedCount() > 0;
		NitriteId id = r.iterator().next();
		assert this.collection.remove(this.collection.getById(id)).getAffectedCount() > 0;
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testRetrive() {
		Document doc = new Document();
		doc.putAll(mapper.convertValue(new Building("Building2", "四川成都3", 123), Map.class));
		WriteResult r = this.collection.insert(doc);
		assert r.getAffectedCount() > 0;
		assert this.collection.getById(r.iterator().next()).get("name") == "Building2";
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testUpdate() {
		Document doc = new Document();
		doc.putAll(mapper.convertValue(new Building("Building3", "四川成都3", 123), Map.class));
		WriteResult r = this.collection.insert(doc);
		NitriteId id = r.iterator().next();
		assert r.getAffectedCount() > 0;
		assert this.collection.getById(id).get("name") == "Building3";
		doc.put("name", "changed");
		assert this.collection.update(doc).getAffectedCount() > 0;
		assert this.collection.getById(id).get("name") == "changed";

	}

}
