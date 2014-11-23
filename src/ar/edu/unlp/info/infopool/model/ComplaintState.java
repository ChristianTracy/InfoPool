package ar.edu.unlp.info.infopool.model;

public abstract class ComplaintState {

	public abstract void check(Complaint complaint);

	public abstract void unCheck(Complaint complaint);
}