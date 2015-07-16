package com.designpattern.visitor;

public class MySubject implements Subject {

	@Override
	public void accepte(Visitor visitor) {
		visitor.visitor(this);
	}

	@Override
	public String getSubject() {
		return "love";
	}

	
}
