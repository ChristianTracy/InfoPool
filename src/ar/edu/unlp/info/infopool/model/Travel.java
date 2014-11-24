package ar.edu.unlp.info.infopool.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CollectionType;

@Entity
public class Travel implements Serializable {
	private static final long serialVersionUID = 6901327150603910816L;
	@Id
	@GeneratedValue
	private long id;

	@ElementCollection(targetClass = WeekDays.class)
	@Enumerated(EnumType.STRING)
	private List<WeekDays> days;
	private String from;
	private Date returnTime;
	private int seats;
	private Date date;
	private String to;

	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "vote_id")
	private List<Vote> votes = new LinkedList<Vote>();

	@ManyToMany(mappedBy = "otherTravels")
	private List<Traveler> travelers = new LinkedList<Traveler>();

	@ManyToOne
	@JoinColumn(name = "driver_id")
	private Traveler driver; // Owner

	public Travel() {

	}

	public void addTraveler(Traveler aTraveler) {
		if (travelers.size() < seats) {
			getTravelers().add(aTraveler);
		}
		// Exception! no hay lugar
	}

	public void addVote(Vote vote) {
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