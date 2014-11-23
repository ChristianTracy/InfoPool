package ar.edu.unlp.info.infopool.model;

public abstract class State {

	public State() {

	}

	public abstract void accept(Request request);

	public abstract void deny(Request request);
}