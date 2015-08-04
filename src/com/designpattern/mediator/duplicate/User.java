package com.designpattern.mediator.duplicate;

public abstract class User {

	private Mediator mediator;

	public Mediator getMediator() {
		return mediator;
	}
	
	public User(Mediator mediator) {
		this.mediator = mediator;
	}
	
	protected abstract void work();
}
