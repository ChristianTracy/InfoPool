package ar.edu.unlp.info.infopool.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Admin extends User {

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