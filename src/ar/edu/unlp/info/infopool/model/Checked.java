package ar.edu.unlp.info.infopool.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Checked extends ComplaintState implements Serializable {
	private static final long serialVersionUID = -7658277833615032807L;

	public Checked() {
	}

	public void check(Complaint complaint) {
		// Do nothing
	}

	public void unCheck(Complaint complaint) {
		complaint.setState(new Unchecked());
	}
	
	public String toString(){
		return "Checked";
	}
}