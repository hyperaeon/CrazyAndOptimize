package com.designpattern.abstractfactory.duplicate;

public class AbstractFactoryTest {

	public static void main(String[] args) {
		Provider factory = new EmailFactory();
		Sender sender = factory.produce();
		sender.send();
		
		factory = new SmsFactory();
		sender = factory.produce();
		sender.send();
	}
}
