package com.designpattern.visitor;

public interface Subject {

	public void accepte(Visitor visitor);
	
	public String getSubject();
}
