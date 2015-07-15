package com.designpattern.observer;

public interface Subject {

	public void add(Observer observer);
	
	public void del(Observer observer);
	
	public void notifyObsevers();
	
	public void operation();
}
