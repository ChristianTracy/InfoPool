package ar.edu.unlp.info.infopool.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unlp.info.infopool.dao.RequestDAO;
import ar.edu.unlp.info.infopool.model.Request;
import ar.edu.unlp.info.infopool.model.Travel;
import ar.edu.unlp.info.infopool.utils.EMF;

public class RequestDAOHibernateJPA extends GenericDAOHibernateJPA<Request>implements RequestDAO  {

	@Override
	public List<Request> getRequestByUserId(Long id) {
		List<Request> queryResult =null;
		EntityManager em = EMF.getEMF().createEntityManager();
		
		Query consulta = em.createQuery(" select r from Request r where request_fk = :driver").setParameter("driver", id);
			queryResult  = (List<Request>)consulta.getResultList();
				return queryResult;
	}

}
