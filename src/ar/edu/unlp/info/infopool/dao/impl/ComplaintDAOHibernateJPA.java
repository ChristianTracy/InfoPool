package ar.edu.unlp.info.infopool.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unlp.info.infopool.dao.ComplaintDAO;
import ar.edu.unlp.info.infopool.model.Complaint;
import ar.edu.unlp.info.infopool.utils.EMF;

public class ComplaintDAOHibernateJPA extends GenericDAOHibernateJPA<Complaint> implements ComplaintDAO{
	public ComplaintDAOHibernateJPA() {
		super(Complaint.class);
	}

	public ComplaintDAOHibernateJPA(Class<Complaint> persistentClass) {
		super(persistentClass);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Complaint> getAll(){
		List<Complaint> resultado =null;
		EntityManager em = EMF.getEMF().createEntityManager();
		Query consulta = em.createQuery(" select c from Complaint c");
				resultado = (List<Complaint>)consulta.getResultList();
				return resultado;
	}
}
