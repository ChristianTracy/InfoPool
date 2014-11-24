package ar.edu.unlp.info.infopool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class State {
	@Id
	@GeneratedValue
	private long id;

	public State() {

	}

	public abstract void accept(Request request);

	public abstract void deny(Request request);
}