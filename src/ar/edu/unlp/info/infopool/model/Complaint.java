package ar.edu.unlp.info.infopool.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Complaint implements Serializable {
	private static final long serialVersionUID = -8208342805026703687L;
	
	@Id
	@GeneratedValue
	private long id;
	
	private String comment;
	
	@ManyToOne
	@JoinColumn(name = "state_id")
	private ComplaintState state;
	
	@OneToOne
	@JoinColumn(name = "owner_fk")
	private Traveler owner;
	
	public Complaint() {
		setState(new Unchecked());
	}

	public void check() {
		getState().check(this);
	}

	public void unCheck() {
		getState().unCheck(this);
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public ComplaintState getState() {
		return state;
	}

	public void setState(ComplaintState state) {
		this.state = state;
	}

	public Traveler getOwner() {
		return owner;
	}

	public void setOwner(Traveler owner) {
		this.owner = owner;
	}

}