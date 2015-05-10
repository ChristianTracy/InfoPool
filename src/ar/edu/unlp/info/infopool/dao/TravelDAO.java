package ar.edu.unlp.info.infopool.dao;

import java.util.List;

import ar.edu.unlp.info.infopool.model.Travel;

public interface TravelDAO extends GenericDAO<Travel>{
	
	public List<Travel> getOtherUsersTravels( Long currentUserId );

	public List<Travel> getUserTravels (Long currentUserId);
	
}
