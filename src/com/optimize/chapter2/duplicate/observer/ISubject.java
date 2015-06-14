package com.optimize.chapter2.duplicate.observer;

public interface ISubject {

	void attach(IObserver observer);

	void dettach(IObserver observer);

	void inform();
}
