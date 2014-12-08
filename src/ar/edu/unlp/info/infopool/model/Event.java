package ar.edu.unlp.info.infopool.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	private boolean deleted = false;
	@OneToMany(mappedBy = "event", cascade = CascadeType.MERGE)
	private List<Travel> travels = new LinkedList<Travel>();
	
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

	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public List<Travel> getTravels() {
		return travels;
	}

	public void setTravels(List<Travel> travels) {
		this.travels = travels;
	}
	public void addTravel(Travel t){
		this.getTravels().add(t);
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}



	
}