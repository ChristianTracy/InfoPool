package ar.edu.unlp.info.infopool.model;

public class Unchecked extends ComplaintState {

	public Unchecked() {

	}

	public void check(Complaint complaint) {
		complaint.setState(new Checked());
	}

	public void unCheck(Complaint complaint) {
		// Do nothing
	}
}