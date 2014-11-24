package ar.edu.unlp.info.infopool.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
//hola estoy comentando
@Entity
public class Admin extends User implements Serializable {
	private static final long serialVersionUID = 5360373134182868086L;
	
	@OneToMany
	@JoinColumn(name = "event_fk")
	private List<Event> events = new LinkedList<Event>();

	public Admin() {
	}

	public void blockUser(Traveler aTraveler) {
		aTraveler.setBlock(true);
	}

	public void createEvent(String name, String location, String description,
			Date date) {
		Event event = new Event(date, description, location, name);
		events.add(event);
	}
}