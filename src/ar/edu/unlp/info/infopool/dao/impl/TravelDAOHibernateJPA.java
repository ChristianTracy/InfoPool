package ar.edu.unlp.info.infopool.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unlp.info.infopool.dao.TravelDAO;
import ar.edu.unlp.info.infopool.model.Travel;
import ar.edu.unlp.info.infopool.utils.EMF;

public class TravelDAOHibernateJPA extends GenericDAOHibernateJPA<Travel>implements TravelDAO{
	public TravelDAOHibernateJPA() {
		super(Travel.class);
	}

	public TravelDAOHibernateJPA(Class<Travel> persistentClass) {
		super(persistentClass);
	}

	@Override
	public List<Travel> getOtherUsersTravels(Long currentUserId) {
		List<Travel> queryResult =null;
		EntityManager em = EMF.getEMF().createEntityManager();
		
		Query consulta = em.createQuery(" select t from Travel t where driver_id <> :driver").setParameter("driver", currentUserId);
			queryResult  = (List<Travel>)consulta.getResultList();;
				return queryResult;
	}

	@Override
	public List<Travel> getUserTravels(Long currentUserId) {
		List<Travel> queryResult =null;
		EntityManager em = EMF.getEMF().createEntityManager();
		
		Query consulta = em.createQuery(" select t from Travel t where driver_id = :driver").setParameter("driver", currentUserId);
			queryResult  = (List<Travel>)consulta.getResultList();;
				return queryResult;
	}
	
	
	
}
