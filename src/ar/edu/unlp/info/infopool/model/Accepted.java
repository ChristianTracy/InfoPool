package ar.edu.unlp.info.infopool.model;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Accepted extends State implements Serializable {
	private static final long serialVersionUID = 2284173225539147904L;


	public Accepted(){

	}

	public void accept(Request request){
		
	}


	public void deny(Request request){
	}
}