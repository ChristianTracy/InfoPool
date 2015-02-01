package ar.edu.unlp.info.infopool.services.impl;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import ar.edu.unlp.info.infopool.dao.UserDAO;
import ar.edu.unlp.info.infopool.model.User;
import ar.edu.unlp.info.infopool.services.AuthenticationService;

@Component
public class AuthenticationServiceImpl extends ActionSupport  implements AuthenticationService {
	private static final long serialVersionUID = 2564444073950556757L;
	private UserDAO userDAO;
	
	@Override
	public User getUserByNameAndPassword(String username, String password) {
		User u = userDAO.getUser(username, password);
		return u;
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	



	
}
