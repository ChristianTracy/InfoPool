package ar.edu.unlp.info.infopool.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Request implements Serializable {
	private static final long serialVersionUID = 6663754861087280750L;
	@Id
	@GeneratedValue
	private long id;

	@OneToOne
	@JoinColumn(name = "owner_fk")
	private Traveler owner; // Quien hace el requerimiento
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "state_fk")
	private State state;
	
	@OneToOne( fetch=FetchType.EAGER)
	@JoinColumn(name="travel_fk")
	private Travel travel; // Viaje seleccionado

	public Request() {
		super();
		this.setState(new Pending());
	}

	public void accept() {
		getState().accept(this);
	}

	public void deny() {
		getState().deny(this);
	}

	public Traveler getOwner() {
		return owner;
	}

	public void setOwner(Traveler owner) {
		this.owner = owner;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}

}