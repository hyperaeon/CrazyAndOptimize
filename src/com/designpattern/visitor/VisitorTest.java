package com.designpattern.visitor;

public class VisitorTest {

	public static void main(String[] args) {
		Visitor visitor = new MyVisitor();
		Subject subject = new MySubject();
		visitor.visitor(subject);
	}
}
