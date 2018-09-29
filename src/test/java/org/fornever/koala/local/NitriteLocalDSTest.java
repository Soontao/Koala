package org.fornever.koala.local;

import static org.junit.Assert.*;

import java.util.Map;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteCollection;
import org.fornever.koala.type.Row;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class NitriteLocalDSTest {

	private Nitrite db;
	private NitriteCollection collection;
	private NitriteLocalDataSource ds;

	private ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setUp() throws Exception {
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
	public void testRetrive() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
