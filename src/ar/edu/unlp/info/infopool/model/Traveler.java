package ar.edu.unlp.info.infopool.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Traveler extends User implements Serializable {

	private static final long serialVersionUID = -7394471909208419408L;
	private String email;
	private String name;
	private String surname;
	private String telephone;
	private boolean deleted = false;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "request_fk")
	private List<Request> requests = new LinkedList<Request>();

	@OneToMany(mappedBy = "receptor", cascade = CascadeType.ALL)
	private List<Message> inbox = new LinkedList<Message>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "complaint_fk")
	private List<Complaint> complaints = new LinkedList<Complaint>();

	@OneToMany(mappedBy = "driver", cascade = CascadeType.MERGE)
	private List<Travel> travels = new LinkedList<Travel>();

	@ManyToMany(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinColumn(name = "travel_id")
	private List<Travel> otherTravels = new LinkedList<Travel>();

	private boolean block;

	public Traveler() {
	}

	public void createTravel(int seats, Date returnTime, String to,
			String from, List<WeekDays> days, Date date) {
		Travel travel = new Travel();
		travel.setDate(date);
		travel.setDays(days);
		travel.setDriver(this);
		travel.setFromAdress(from);
		travel.setReturnTime(returnTime);
		travel.setSeats(seats);
		travel.setToAdress(to);
		this.getTravels().add(travel);
	}

	public void sendMessage(String text, Traveler aTraveler) {
		Message msj = new Message();
		msj.setOwner(this);
		msj.setText(text);
		aTraveler.addMessage(msj);
	}

	public void addMessage(Message msj) {
		getInbox().add(msj);
	}

	public void sendRequest(Travel aTravel, Traveler aTraveler) {
		Request rqst = new Request();
		rqst.setTravel(aTravel);
		rqst.setOwner(this);
		aTraveler.addRequest(rqst);

	}

	public void addRequest(Request rqst) {
		getRequests().add(rqst);

	}

	public void addPositiveVote(Travel travel) {
		Positive vote = new Positive();
		travel.addVote(vote);
	}

	public void addNegativeVote(Travel travel) {
		Negative vote = new Negative();
		travel.addVote(vote);
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

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public List<Message> getInbox() {
		return inbox;
	}

	public void setInbox(List<Message> inbox) {
		this.inbox = inbox;
	}

	public List<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}

	public List<Travel> getTravels() {
		return travels;
	}

	public void setTravels(List<Travel> travels) {
		this.travels = travels;
	}

	public boolean isBlock() {
		return block;
	}

	public void setBlock(boolean block) {
		this.block = block;
	}

	public List<Travel> getOtherTravels() {
		return otherTravels;
	}

	public void setOtherTravels(List<Travel> otherTravels) {
		this.otherTravels = otherTravels;
	}

	public void addComplaint(Complaint c) {
		this.getComplaints().add(c);
	}

	public void addTravel(Travel t) {
		this.getTravels().add(t);
	}

	public void addOtherTravel(Travel t) {
		this.getOtherTravels().add(t);
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public boolean isTraveler() {
		return true;
	}

	@Override
	public boolean isAdmin() {
		return false;
	}

}