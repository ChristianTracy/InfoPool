package ar.edu.unlp.info.infopool.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ar.edu.unlp.info.infopool.dao.UserDAO;
import ar.edu.unlp.info.infopool.model.User;

@Repository
public class UserDAOHibernateJPA extends GenericDAOHibernateJPA<User> implements
		UserDAO {
	public UserDAOHibernateJPA() {
		super(User.class);
	}

	public UserDAOHibernateJPA(Class<User> persistentClass) {
		super(persistentClass);
	}

	public User exist(String username, String password) {
		Query query = this
				.getEntityManagerFactory()
				.createQuery(
						"SELECT u FROM User AS u WHERE u.username = :username and password = :password",
						User.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		try {
			User result = (User) query.getSingleResult();
			return result;
		} catch (NoResultException e) {
			return null;
		}
	}

}
