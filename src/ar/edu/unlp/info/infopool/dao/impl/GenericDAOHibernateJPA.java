package ar.edu.unlp.info.infopool.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ar.edu.unlp.info.infopool.dao.GenericDAO;
import ar.edu.unlp.info.infopool.utils.EMF;

public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {
	protected Class<T> persistentClass;

	public GenericDAOHibernateJPA(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	// PRUEBA CON REFLECTION
	// @SuppressWarnings("unchecked")
	// public GenericDAOHibernateJPA() {
	// this.persistentClass = (Class<T>) ((ParameterizedType)
	// getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	// }

	@Override
	public void add(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		em.persist(entity);
		em.flush();
		etx.commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(Long id) {
		EntityManager em = EMF.getEMF().createEntityManager();
		Query consulta = em.createQuery("select t from "
				+ getPersistentClass().getSimpleName() + " t where id = " + id
				+ "");
		T result = (T) consulta.getSingleResult();
		return result;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

}
