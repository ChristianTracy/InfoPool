package ar.edu.unlp.info.infopool.actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import ar.edu.unlp.info.infopool.dao.EventDAO;
import ar.edu.unlp.info.infopool.model.Event;

import com.opensymphony.xwork2.ActionSupport;

public class EventAction extends ActionSupport{
	
	private static final long serialVersionUID = -5583342413515224180L;
	private EventDAO eventDAO;	
	private Date date;
	private String time;
	private String description;
	private String location;
	private String name;
	private boolean deleted = false;
	private List<Event> eventCollection;
	
	public Date getDate() {
		return date;
	}
	
	

	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public List<Event> getEventCollection() {
		return eventCollection;
	}



	public void setEventCollection(List<Event> eventCollection) {
		this.eventCollection = eventCollection;
	}


	public void setDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date d;
		try {
			d = (Date) format.parse(date);
			this.date = d;
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
		
		return "success";
	}
	
	public String newEvent(){
		Event e =new Event();
		e.setDate(date);
		e.setDescription(description);
		e.setLocation(location);
		e.setName(name);
		if(this.checkevent(e)){
			eventDAO.add(e);
			
			return "success";
		}
		else {
			addFieldError("error", "Debe completar todos los campos");
			return "error";
		}
	}

	private boolean checkevent(Event e) {
		if ((e.getDate().getTime() == 0)|| e.getDescription().isEmpty()
				||e.getLocation().isEmpty()||e.getName().isEmpty()){
			return false;
		}
		else {
			return true;
		}
	}

	
	public EventDAO getEventDAO() {
		return eventDAO;
	}

	public void setEventDAO(EventDAO eventDAO) {
		this.eventDAO = eventDAO;
	}

	// This method return list of events in database
    public String listEvents() {
    	eventCollection = (List<Event>) eventDAO.getAll();
    	return "success";
    }

	
}
