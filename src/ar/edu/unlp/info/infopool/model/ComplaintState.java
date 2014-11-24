package ar.edu.unlp.info.infopool.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ComplaintState implements Serializable {
	private static final long serialVersionUID = -6429046015129394642L;
	@Id
	@GeneratedValue
	private long id;
	public abstract void check(Complaint complaint);

	public abstract void unCheck(Complaint complaint);
}