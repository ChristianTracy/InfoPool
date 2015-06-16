package ar.edu.unlp.info.infopool.dao;

import java.util.List;

import ar.edu.unlp.info.infopool.model.Request;


public interface RequestDAO extends GenericDAO<Request>{
	public List<Request> getRequestByUserId(Long id);
}
