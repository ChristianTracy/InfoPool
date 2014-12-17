package ar.edu.unlp.info.infopool.actions;

import java.util.Map;

import ar.edu.unlp.info.infopool.dao.UserDAO;
import ar.edu.unlp.info.infopool.model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	public String usuario;
	public String pass;
	private UserDAO userDAO;

	public String execute() {
//		Map<String, Object> session = ActionContext.getContext().getSession();
//		String user = (String) session.get("user");
//		if (user == null) {
//			String u = "usuario";
//			if (u != null) {
//				session.put("usuario", u);
//				return "success";
//			} else {
//				addFieldError("usuario", "Datos Incorrectos");
//				return "input";
//			}
//		} else {
//			return "conectado";
//		}
		System.out.println("estoy en el action");
		return "input";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
