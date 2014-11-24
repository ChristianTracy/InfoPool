package ar.edu.unlp.info.infopool.model;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Unchecked extends ComplaintState implements Serializable {
	private static final long serialVersionUID = 4257038604382705345L;

	public Unchecked() {

	}

	public void check(Complaint complaint) {
		complaint.setState(new Checked());
	}

	public void unCheck(Complaint complaint) {
		// Do nothing
	}
}