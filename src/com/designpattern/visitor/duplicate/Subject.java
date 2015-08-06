package com.designpattern.visitor.duplicate;

public interface Subject {

	public void accept(Visitor visitor);
	
	public String getSubject();
	
	public String newFunction();
}
