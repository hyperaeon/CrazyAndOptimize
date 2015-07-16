package com.designpattern.mediator;

public class MediatorTest {

	public static void main(String[] args) {
		MyMediator mediator = new MyMediator();
		mediator.createMediator();
		mediator.workAll();
	}
}
