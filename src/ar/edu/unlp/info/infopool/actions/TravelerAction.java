package ar.edu.unlp.info.infopool.actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import ar.edu.unlp.info.infopool.dao.TravelDAO;
import ar.edu.unlp.info.infopool.dao.UserDAO;
import ar.edu.unlp.info.infopool.model.Travel;
import ar.edu.unlp.info.infopool.model.Traveler;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TravelerAction extends ActionSupport {
	private static final long serialVersionUID = 983509072531914212L;
	private Map<String, Object> session = ActionContext.getContext().getSession();
	private TravelDAO travelDAO;
	Date date;
	String fromAdress;
	String toAdress;
	Date returnTime;
	int seats;
	String event;

	public String execute() {
		return "success";
	}

	public String newTravel() {
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
			t.setReturnTime(this.getReturnTime());
			t.setSeats(this.getSeats());
			travelDAO.add(t);
			return "success";
		}
		else{
			return "error";
		}
	}

	private boolean informationIsValid() {
		if (this.getFromAdress().isEmpty() || this.getToAdress().isEmpty()
				|| this.getDate().getTime() == 0 || this.getReturnTime().getTime() == 0 || this.getSeats() < 0) {
			return false;
		} else {
			return true;
		}
	}


	public void setDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm");
		Date d;
		try {
			d = (Date) format.parse(date);
			this.date = d;
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public void setReturnTime(String returnTime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm");
		Date d;
		try {
			d = (Date) format.parse(returnTime);
			this.returnTime = d;
		} catch (ParseException e) {
			e.printStackTrace();
		}
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

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

}
