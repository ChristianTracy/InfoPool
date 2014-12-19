package ar.edu.unlp.info.infopool.actions;

import java.util.Map;

import ar.edu.unlp.info.infopool.dao.UserDAO;
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

	
	public String autenticate(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		User usersession = (User) session.get("user");
		if (usersession == null) {
			User u = userDAO.exist("admin","admin");
			if (u != null) {
				session.put("user", u);
				return "success";
			} else {
				addFieldError("usuario", "Datos Incorrectos");
				return "badlogin";
			}
		} else {
			return "logged";
		}		
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
