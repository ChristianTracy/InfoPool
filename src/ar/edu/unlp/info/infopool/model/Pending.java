package ar.edu.unlp.info.infopool.model;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Pending extends State implements Serializable{
	private static final long serialVersionUID = -8199489895283621816L;

	public Pending() {

	}

	public void accept(Request request) {
		request.setState(new Accepted());
	}

	public void deny(Request request) {
		request.setState(new Denied());
	}

	@Override
	public void pending(Request request) {
		// Do nothing
		
	}
}