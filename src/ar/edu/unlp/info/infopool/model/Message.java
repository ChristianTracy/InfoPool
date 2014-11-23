package ar.edu.unlp.info.infopool.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Message implements Serializable {
	private static final long serialVersionUID = 9169212010295071285L;

	@Id
	@GeneratedValue
	private long id;

	private String text;

	@OneToOne
	@JoinColumn(name = "owner_fk")
	private Traveler owner;

	@ManyToOne
	@JoinColumn(name = "receptor_id")
	private Traveler receptor;

	public Message() {

	}

	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Traveler getOwner() {
		return owner;
	}

	public void setOwner(Traveler owner) {
		this.owner = owner;
	}

}