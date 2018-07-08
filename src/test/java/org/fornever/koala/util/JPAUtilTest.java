package org.fornever.koala.util;

import org.fornever.koala.types.MobilePhone;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.Query;

public class JPAUtilTest {

	@Test
	public void createH2EntityManagerTest() {
		EntityManager edm = JPAUtil.createH2EntityManager();
		edm.setFlushMode(FlushModeType.COMMIT);
		edm.getTransaction().begin();
		MobilePhone p = new MobilePhone().setPhoneNumber("15680437825").setPhoneOwnerName("Theo");
		edm.persist(p);
		edm.getTransaction().commit();
		Query select = edm.createQuery("select m from MobilePhone m");
		assert select.getResultList().size() == 1;
	}


}
