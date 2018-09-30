package org.fornever.koala.local;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteCollection;
import org.fornever.koala.ds.local.NitriteLocalDataSource;
import org.fornever.koala.type.Row;
import org.junit.After;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class NitriteLocalDSTest {

	private Nitrite db;
	private NitriteCollection collection;
	private NitriteLocalDataSource ds;

	private ObjectMapper mapper = new ObjectMapper();

	public NitriteLocalDSTest() {
		this.db = Nitrite.builder().openOrCreate();
		this.collection = this.db.getCollection("buildings");
		this.ds = new NitriteLocalDataSource(this.collection);
	}

	@After
	public void tearDown() throws Exception {
		this.db.close();
	}

	@Test
	public void testCreate() {

		Row rt = this.ds.create(mapper.convertValue(new Building("Building1", "四川成都", 123), Row.class));
		assert rt.get("name").equals("Building1");

	}

	@Test
	public void testDelete() {
		Row rt = this.ds.create(mapper.convertValue(new Building("Building1", "四川成都", 123), Row.class));
		Object id = rt.get("_id");
		assert id != null;
		assert this.ds.delete(id);
		assert this.ds.retrieve(id) == null;

	}

	@Test
	public void testRetrive() {

		Row rt = this.ds.create(mapper.convertValue(new Building("Building1", "四川成都", 123), Row.class));
		Object id = rt.get("_id");
		assert this.ds.retrieve(id) != null;

	}

	@Test
	public void testUpdate() throws NumberFormatException, Throwable {

		Row rt = this.ds.create(mapper.convertValue(new Building("Building1", "四川成都", 123), Row.class));
		rt.put("name", "B2");
		assert this.ds.update(rt).get("name") == "B2";

	}

}
