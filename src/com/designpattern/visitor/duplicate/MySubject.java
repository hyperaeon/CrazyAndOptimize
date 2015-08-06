package com.designpattern.visitor.duplicate;

public class MySubject implements Subject {

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String getSubject() {
		return "love";
	}

	@Override
	public String newFunction() {
		return "this is new function";
	}

}
