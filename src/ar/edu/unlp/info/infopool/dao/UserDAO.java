package ar.edu.unlp.info.infopool.dao;

import ar.edu.unlp.info.infopool.model.User;

public interface UserDAO extends GenericDAO<User> {
	
	public User exist(String username, String password );
	

}
