package ar.edu.unlp.info.infopool.dao.impl;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.info.infopool.dao.EventDAO;
import ar.edu.unlp.info.infopool.model.Event;

@Repository
public class EventDAOHibernateJPA  extends GenericDAOHibernateJPA<Event> implements EventDAO{

	public EventDAOHibernateJPA() {
		super(Event.class);
	}

	public EventDAOHibernateJPA(Class<Event> persistentClass) {
		super(persistentClass);
	}
	
}
