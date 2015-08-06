package com.designpattern.visitor.duplicate;

public class VisitorTest {

	public static void main(String[] args) {
		Visitor visitor = new MyVisitor();
		Subject subject = new MySubject();
		subject.accept(visitor);
	}
}
