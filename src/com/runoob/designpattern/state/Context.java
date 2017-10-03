package com.runoob.designpattern.state;

public class Context {

	private State state;
	
	public Context() {
		state = null;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
}
