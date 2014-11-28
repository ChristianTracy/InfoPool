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
		T result = null;
		EntityManager em = EMF.getEMF().createEntityManager();
		Query consulta = em.createQuery("select t from "
				+ getPersistentClass().getSimpleName() + " t where id = " + id
				+ "");
		result = (T) consulta.getSingleResult();
		if (result == null) {
			System.out.println("No se pudo obtener el objeto con id:" + id);
		}
		return result;
	}

	@Override
	public void delete(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			T managed = em.merge(entity);
			em.remove(managed);
			em.flush();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			System.out.println("Error en la transacci�n");
			throw e;
		} finally {
			em.close();
		}
	}

	@Override
	public T delete(Long id) {
		T entity = EMF.getEMF().createEntityManager().find(this.getPersistentClass(), id);
		if (entity != null) {
			this.delete(entity);
		}
		return entity;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

}
