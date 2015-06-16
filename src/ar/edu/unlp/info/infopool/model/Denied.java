package ar.edu.unlp.info.infopool.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Denied extends State implements Serializable {
	private static final long serialVersionUID = -710823708030720057L;

	public Denied() {

	}

	public void accept(Request request) {
		request.setState(new Accepted());
	}

	public void deny(Request request) {
		
	}

	@Override
	public void pending(Request request) {
		// Do nothing
		
	}
	
	public String toString(){
		return "Denied";
	}
}