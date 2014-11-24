package ar.edu.unlp.info.infopool.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vote implements Serializable{
	private static final long serialVersionUID = 163056959265440589L;
	@Id
	@GeneratedValue
	private long id;
	private String comment;

	public Vote() {

	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}