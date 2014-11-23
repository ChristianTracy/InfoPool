package ar.edu.unlp.info.infopool.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EMF {
	private static final EntityManagerFactory em;

	static {
		em = Persistence.createEntityManagerFactory("infoPool");
	}

	public static EntityManagerFactory getEMF() {
		return em;
	}

}
