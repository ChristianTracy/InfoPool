package ar.edu.unlp.info.infopool.services;

import ar.edu.unlp.info.infopool.model.User;

public interface AuthenticationService {
	public User getUserByNameAndPassword(String username, String password);
}
