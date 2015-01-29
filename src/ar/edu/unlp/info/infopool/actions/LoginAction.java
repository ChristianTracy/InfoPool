package ar.edu.unlp.info.infopool.actions;

import java.util.Map;

import ar.edu.unlp.info.infopool.dao.UserDAO;
import ar.edu.unlp.info.infopool.model.Admin;
import ar.edu.unlp.info.infopool.model.Traveler;
import ar.edu.unlp.info.infopool.model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	private static final long serialVersionUID = -294055426001660258L;
	public String user;
	public String password;
	private UserDAO userDAO;

	public String execute() {
		return "success";
	}

	//VALIDATE() 
	public String autenticate(){
		System.out.println("AUTENTICATE");
		Map<String, Object> session = ActionContext.getContext().getSession();
		User usersession = (User) session.get("user");
		if (usersession == null) {
			User u = userDAO.exist(this.getUser(),this.getPassword());
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
				return "success";
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


}
