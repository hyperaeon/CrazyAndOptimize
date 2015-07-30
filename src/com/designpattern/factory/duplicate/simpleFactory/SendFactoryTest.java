package com.designpattern.factory.duplicate.simpleFactory;

public class SendFactoryTest {

	public static void main(String[] args) {
		SendFactory factory = new SendFactory();
		Sender send = factory.produce("sms");
		send.send();
	}
}
