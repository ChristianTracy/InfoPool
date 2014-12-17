package ar.edu.unlp.info.infopool.dao.impl;

import ar.edu.unlp.info.infopool.model.User;

public class UserDAOHibernateJPA extends GenericDAOHibernateJPA<User> {
	
	public UserDAOHibernateJPA() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDAOHibernateJPA(Class<User> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}

}
