package ar.edu.unlp.info.infopool.model;

public class Pending extends State {

	public Pending() {

	}

	public void accept(Request request) {
		request.setState(new Accepted());
	}

	public void deny(Request request) {
		request.setState(new Denied());
	}
}