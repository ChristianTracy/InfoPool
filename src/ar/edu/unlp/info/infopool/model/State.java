package ar.edu.unlp.info.infopool.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class State implements Serializable {

	private static final long serialVersionUID = -6008799876757530517L;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;

	public abstract void accept(Request request);
	public abstract void pending(Request request);
	public abstract void deny(Request request);
}