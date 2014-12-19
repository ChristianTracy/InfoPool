package ar.edu.unlp.info.infopool.dao.impl;

import javax.persistence.EntityManager;

import ar.edu.unlp.info.infopool.dao.UserDAO;
import ar.edu.unlp.info.infopool.model.User;

public class UserDAOHibernateJPA extends GenericDAOHibernateJPA<User> implements UserDAO{
	
	public UserDAOHibernateJPA() {
		super();
	}

	public UserDAOHibernateJPA(Class<User> persistentClass) {
		super(persistentClass);
	}

	public User exist(String username, String password ){
		String query = "from User u where u.username like " +username+ "and u.password like " +password ;
		User result = (User) this.getEntityManager().createQuery(query).getSingleResult();
		return result;
	}

}
