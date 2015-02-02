package ar.edu.unlp.info.infopool.actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
	
	public Date getDate() {
		return date;
	}

	public void setDate(String date) {
//		System.out.println(date);
		
		SimpleDateFormat otroFormato = new SimpleDateFormat("yyyy-mm-dd",Locale.ENGLISH);
		String fec = date;
		try {
			Date nuevo = (Date) otroFormato.parse(fec);
			this.date=nuevo;
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
//		
//		SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
//		String dateInString = date;		
//		try {
//	 
//			Date adate = formatter.parse(dateInString);
//			System.out.println(adate);
//			System.out.println(formatter.format(adate));
//	 
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
//		Calendar cal = Calendar.getInstance();
//		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
//		try {
//			cal.setTime(sdf.parse(date));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}// all done
//		this.date= date;
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
	
	public String newevent(){
		System.out.println(date);
//		System.out.println(time);
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
    public String listevents() {
    	
        return SUCCESS;
    }
 
	
	
}
