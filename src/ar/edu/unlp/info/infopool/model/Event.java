package ar.edu.unlp.info.infopool.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Event implements Serializable{
	private static final long serialVersionUID = -6249564396944050268L;
	@Id
	@GeneratedValue
	private long id;
	private Date date;
	private String description;
	private String location;
	private String name;

	public Event() {

	}

	public Event(Date date, String description, String location, String name) {
		super();
		this.date = date;
		this.description = description;
		this.location = location;
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

}