package com.runoob.designpattern.mediator;

public class MediatorPatternDemo {

	public static void main(String[] args) {
		User robert= new User("Robert");
		User john= new User("John");
		robert.sendMessage("Hi, johne");
		john.sendMessage("Hi, robert");
	}
}
