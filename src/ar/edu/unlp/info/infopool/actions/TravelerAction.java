package ar.edu.unlp.info.infopool.actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import ar.edu.unlp.info.infopool.dao.EventDAO;
import ar.edu.unlp.info.infopool.dao.TravelDAO;
import ar.edu.unlp.info.infopool.dao.impl.GenericDAOHibernateJPA;
import ar.edu.unlp.info.infopool.model.Complaint;
import ar.edu.unlp.info.infopool.model.Event;
import ar.edu.unlp.info.infopool.model.Request;
import ar.edu.unlp.info.infopool.model.Travel;
import ar.edu.unlp.info.infopool.model.Traveler;
import ar.edu.unlp.info.infopool.model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TravelerAction extends ActionSupport {
	private static final long serialVersionUID = 983509072531914212L;
	private Map<String, Object> session = ActionContext.getContext().getSession();
	private Traveler traveler;
	private List<Travel> myTravels;
	private List<Travel> otherTravels;
	private TravelDAO travelDAO;
	private EventDAO eventDAO;
	private List<Request> travelRequests;
	private List<Event> eventCollection;
	Date date;
	String fromAdress;
	String toAdress;
	Date returnTime;
	int seats;
	Long event;
	Long reportedId;

	public String execute() {
		return "success";
	}

	public String newTravel() {
		eventCollection = (List<Event>) eventDAO.getAll();
		return "success";
	}

	public String submitTravel() {
		if (informationIsValid()){
			Traveler loguedUser = (Traveler) session.get("user");
			Travel t = new Travel();
			t.setDriver(loguedUser);
			t.setFromAdress(this.getFromAdress());
			t.setToAdress(this.getToAdress());
			t.setDate(this.getDate());
			if (this.getReturnTime() !=null){
				t.setReturnTime(this.getReturnTime());
			}
			t.setSeats(this.getSeats());
			if (event != null){
				Event e = eventDAO.getById(event);
				t.addEvent(e);
			}
			travelDAO.add(t);
			return "success";
		}
		else{
			return "error";
		}
	}

	private boolean informationIsValid() {
		if (this.getFromAdress().isEmpty() || this.getToAdress().isEmpty()
				|| this.getDate().getTime() == 0 || this.getSeats() < 0) {
			return false;
		} else {
			return true;
		}
	}


	public void setDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date d;
		try {
			d = (Date) format.parse(date);
			this.date = d;
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public void setReturnTime(String returnTime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date d;
		try {
			d = (Date) format.parse(returnTime);
			this.returnTime = d;
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public String travelRequests(){
		Traveler loguedUser = (Traveler) session.get("user");
		travelRequests = loguedUser.getRequests();
		return "success";
	}

	 public String render() {
		 traveler =  (Traveler) session.get("user");
		 User loguedUser = (User) session.get("user");
		 otherTravels = traveler.getOtherTravels();
		 myTravels = (List<Travel>)travelDAO.getUserTravels(loguedUser.getId());
	    return "success";
	 }
	
	 public void newComplaint(){
		 GenericDAOHibernateJPA<Traveler>travelerDao = new GenericDAOHibernateJPA<Traveler>(Traveler.class);
		 Complaint complaint = new Complaint();
		 traveler =  (Traveler) session.get("user");
		 complaint.setOwner(traveler);
		 complaint.setComment("comentario");
		 Traveler reported = travelerDao.getById(this.getReportedId());
		 reported.addComplaint(complaint);
		 travelerDao.update(reported);
	 }
	 
	public TravelDAO getTravelDAO() {
		return travelDAO;
	}

	public void setTravelDAO(TravelDAO travelDAO) {
		this.travelDAO = travelDAO;
	}

	public Date getDate() {
		return date;
	}
	
	
	public String getFromAdress() {
		return fromAdress;
	}

	public void setFromAdress(String fromAdress) {
		this.fromAdress = fromAdress;
	}

	public String getToAdress() {
		return toAdress;
	}

	public void setToAdress(String toAdress) {
		this.toAdress = toAdress;
	}

	public Date getReturnTime() {
		return returnTime;
	}



	public int getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = Integer.parseInt(seats);
	}

	public Long getEvent() {
		return event;
	}

	public void setEvent(Long event) {
		this.event = event;
	}

	public EventDAO getEventDAO() {
		return eventDAO;
	}

	public void setEventDAO(EventDAO eventDAO) {
		this.eventDAO = eventDAO;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public List<Event> getEventCollection() {
		return eventCollection;
	}

	public void setEventCollection(List<Event> eventCollection) {
		this.eventCollection = eventCollection;
	}

	public List<Request> getTravelRequests() {
		return travelRequests;
	}

	public void setTravelRequests(List<Request> travelRequests) {
		this.travelRequests = travelRequests;
	}

	public List<Travel> getMyTravels() {
		return myTravels;
	}

	public void setMyTravels(List<Travel> myTravels) {
		this.myTravels = myTravels;
	}

	public Traveler getTraveler() {
		return traveler;
	}

	public void setTraveler(Traveler traveler) {
		this.traveler = traveler;
	}

	public List<Travel> getOtherTravels() {
		return otherTravels;
	}

	public void setOtherTravels(List<Travel> otherTravels) {
		this.otherTravels = otherTravels;
	}

	public Long getReportedId() {
		return reportedId;
	}

	public void setReportedId(Long reportedId) {
		this.reportedId = reportedId;
	}
	
	

}
