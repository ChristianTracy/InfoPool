package ar.edu.unlp.info.infopool.dao.impl;

import ar.edu.unlp.info.infopool.dao.TravelDAO;
import ar.edu.unlp.info.infopool.model.Travel;

public class TravelDAOHibernateJPA extends GenericDAOHibernateJPA<Travel>implements TravelDAO{
	public TravelDAOHibernateJPA() {
		super(Travel.class);
	}

	public TravelDAOHibernateJPA(Class<Travel> persistentClass) {
		super(persistentClass);
	}
}
