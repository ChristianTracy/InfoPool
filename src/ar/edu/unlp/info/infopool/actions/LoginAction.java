package ar.edu.unlp.info.infopool.actions;

import java.util.Map;

import ar.edu.unlp.info.infopool.dao.UserDAO;
import ar.edu.unlp.info.infopool.model.Admin;
import ar.edu.unlp.info.infopool.model.Traveler;
import ar.edu.unlp.info.infopool.model.User;
import ar.edu.unlp.info.infopool.services.AuthenticationService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	private static final long serialVersionUID = -294055426001660258L;
	public String user;
	public String password;
	private UserDAO userDAO;
	private AuthenticationService authenticationService;
	private Map<String, Object> session = ActionContext.getContext().getSession();
	
	public String execute() {
		return "success";
	}

	//VALIDATE() 
	public String autenticate(){		
		User loguedUser = (User) session.get("user");
		if (loguedUser == null) {
			User u = authenticationService.getUserByNameAndPassword(this.getUser(), this.getPassword());
			if (u != null) {
				if (u.isAdmin()){
					Admin adminLogued = (Admin) u;
					session.put("user", adminLogued);
					return "admin";
				}
				else{
					Traveler loguedTraveler = (Traveler) u;
					session.put("user", loguedTraveler);
				}
				return "traveler";
			} else {
				addFieldError("error", "Datos Incorrectos");
				return "badlogin";
			}
		} else {
			return "logged";
		}		
	}
	
	public String logOut(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("user", null);
		return "exit";
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public AuthenticationService getAuthenticationService() {
		return authenticationService;
	}

	public void setAuthenticationService(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}
	
	public String renderAdmin(){
		User logued = (User)session.get("user");
		if (logued != null){
			if (logued.isAdmin()){
				return "success";
			}
			else{
				return "error";
			}			
		}
		else{
			return "error";
		}

	}

	public String renderTraveler(){
		User logued = (User)session.get("user");
		if (logued != null){
			if (!logued.isAdmin()){
				return "success";
			}
			else{
				return "error";
			}			
		}
		else{
			return "error";
		}

	}
	

}
