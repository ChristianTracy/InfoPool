package ar.edu.unlp.info.infopool.model;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Denied extends State implements Serializable {
	private static final long serialVersionUID = -710823708030720057L;

	public Denied() {

	}

	public void accept(Request request) {

	}

	public void deny(Request request) {

	}
}