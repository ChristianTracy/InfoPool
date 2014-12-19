package ar.edu.unlp.info.infopool.actions;

import java.util.Date;

import ar.edu.unlp.info.infopool.dao.impl.GenericDAOHibernateJPA;
import ar.edu.unlp.info.infopool.model.Event;

import com.opensymphony.xwork2.ActionSupport;

public class EventAction extends ActionSupport{
	
	private static final long serialVersionUID = -5583342413515224180L;
	private GenericDAOHibernateJPA<Event> eventDAO;	
	private Date date;
	private String description;
	private String location;
	private String name;
	private boolean deleted = false;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public EventAction() {
	}
	
	public String execute() {
		Event e =null;
		e.setDate(date);
		e.setDescription(description);
		e.setLocation(location);
		e.setName(name);
		eventDAO.add(e);
		return "success";
	}

	
	public String validEvent(){
		return "";
	}

}
