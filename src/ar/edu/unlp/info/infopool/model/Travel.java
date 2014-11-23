package ar.edu.unlp.info.infopool.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Travel {

	private List<WeekDays> days;
	private String from;
	private Date returnTime;
	private int seats;
	private Date date;
	private String to;
	public List<Vote> votes = new LinkedList<Vote>();
	public List<Traveler> travelers = new LinkedList<Traveler>();
	public Traveler driver;

	public Travel() {

	}

	public void addTraveler(Traveler aTraveler) {
		if(travelers.size() < seats){
			getTravelers().add(aTraveler);
		}
		//Exception! no hay lugar
	}

	public void addVote(Vote vote){
		getVotes().add(vote);
	}
	
	public List<WeekDays> getDays() {
		return days;
	}

	public void setDays(List<WeekDays> days) {
		this.days = days;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

	public List<Traveler> getTravelers() {
		return travelers;
	}

	public void setTravelers(List<Traveler> travelers) {
		this.travelers = travelers;
	}

	public Traveler getDriver() {
		return driver;
	}

	public void setDriver(Traveler driver) {
		this.driver = driver;
	}

	
	

}