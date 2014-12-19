package ar.edu.unlp.info.infopool.actions;

import com.opensymphony.xwork2.ActionSupport;

import ar.edu.unlp.info.infopool.dao.UserDAO;
import ar.edu.unlp.info.infopool.model.Traveler;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = -6611618073361989317L;
	private UserDAO userDAO;
	private String email;
	private String name;
	private String surname;
	private String telephone;
	private String password;
	private String username;

	public RegisterAction() {
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	
	public String excute(){
		return "success";
	}
	
	public String submit() {
		Traveler t = new Traveler();
		t.setUsername(username);
		t.setPassword(password);
		t.setEmail(email);
		t.setName(name);
		t.setSurname(surname);
		t.setTelephone(telephone);
		if (this.check(t)){
			userDAO.add(t);
			return  "success";
		}
		else{
			addFieldError("error", "Debe completar todos los campos");
			return "error";
		}

			
	}

	private boolean check(Traveler t) {
		// if (t.getEmail() == "" || t.getName() == "" || t.getPassword() == ""
		// || t.getSurname() == "" || t.getTelephone() == "" || t.getUsername()
		// == ""){
		// }
		if (t.getEmail().isEmpty() || t.getName().isEmpty()
				|| t.getPassword().isEmpty() || t.getSurname().isEmpty()
				|| t.getTelephone().isEmpty() || t.getUsername().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

}
