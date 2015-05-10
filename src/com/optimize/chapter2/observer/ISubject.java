package com.optimize.chapter2.observer;

public interface ISubject {

	void attach(IObserver observer);
	
	void detach(IObserver observer);
	
	void inform();
}
