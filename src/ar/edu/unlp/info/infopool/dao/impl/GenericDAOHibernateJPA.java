package ar.edu.unlp.info.infopool.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.info.infopool.dao.GenericDAO;
import ar.edu.unlp.info.infopool.utils.EMF;
@Repository
public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {
	protected Class<T> persistentClass;
	
    @PersistenceContext(unitName = "infoPool")
    private EntityManager entityManagerFactory;

	public GenericDAOHibernateJPA() {
		super();
	}

	public GenericDAOHibernateJPA(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}



	public EntityManager getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManager entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

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
			System.out.println("Error en la transacción");
			throw e;
		} finally {
			em.close();
		}
	}

	@Override
	public T delete(Long id) {
		T entity = EMF.getEMF().createEntityManager()
				.find(this.getPersistentClass(), id);
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

	@Override
	public T update(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		T result = em.merge(entity);
		etx.commit();
		em.close();
		return result;
	}

	public boolean exist(Long id) {
		T result = this.getById(id);
		if (result == null) {
			return false;
		} else {
			return true;
		}

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(){
		List<T> resultado =null;
		EntityManager em = EMF.getEMF().createEntityManager();
		Query consulta = em.createQuery(" from "+ getPersistentClass().getSimpleName());
				resultado = (List<T>)consulta.getResultList();
				return resultado;
	}
	
//	public Collection<T> getAll() {
//	    Query consulta=this.getEm().createQuery(" from "+ getPersistentClass().getSimpleName());
//		Collection<T>resultado=consulta.getResultList();
//		return resultado;
//	

}
