package org.fornever.koala;

import org.fornever.koala.remote.ODataRemoteDataSource;
import org.fornever.koala.type.Row;
import org.fornever.koala.type.SearchParameter;
import org.junit.Assume;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.JVM)
public class ODataRemoteDSTest {

	ODataRemoteDataSource ds;

	Row testRow = new Row() {
		private static final long serialVersionUID = -4489660920981768196L;

		{
			put("ID", "952");
		}
	};

	@Before
	public void setUp() throws Exception {

		String uri = System.getenv("TEST_ODATA_URI");
		String user = System.getenv("TEST_ODATA_USER");
		String pass = System.getenv("TEST_ODATA_PASS");
		if (uri != null && user != null && pass != null) {
			this.ds = new ODataRemoteDataSource(uri, user, pass);
		}
	}

	@Test
	public void testCreate() throws Throwable {
		Assume.assumeNotNull(this.ds);
		Row created = this.ds.create(this.testRow);
		assert created != null;
		String objectId = created.get("ObjectID").toString();
		assert objectId != null;
		assert this.ds.delete(objectId);
	}

	@Test
	public void testFind() throws Throwable {
		Assume.assumeNotNull(this.ds);
		assert this.ds.find(SearchParameter.New().setSize(15)).size() == 15;
	}

	@Test
	public void testRetrieve() throws Throwable {
		Assume.assumeNotNull(this.ds);
		assert this.ds.retrieve("00163E20C98D1ED8B0C3F594FF12C050") != null;
	}

	@Test
	public void testUpdate() throws Throwable {
		Assume.assumeNotNull(this.ds);
		Row created = this.ds.create(this.testRow);
		assert created != null;
		String objectId = created.get("ObjectID").toString();
		Row updated = new Row();
		updated.put("ID", "123");
		Row returned = this.ds.update(objectId, updated);
		assert returned.get("ID").equals("123");
		assert this.ds.delete(objectId);
	}

}
