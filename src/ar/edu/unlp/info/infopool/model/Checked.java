package ar.edu.unlp.info.infopool.model;

public class Checked extends ComplaintState {

	public Checked() {

	}

	public void check(Complaint complaint) {
		// Do nothing
	}

	public void unCheck(Complaint complaint) {
		complaint.setState(new Unchecked());
	}
}