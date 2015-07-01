package com.designpattern.abstractfactory;

public class AbstractFactoryTest {

	public static void main(String[] args) {
		Provider provider = new SendMailFactory();
		Sender sender = provider.produce();
		sender.send();
		provider = new SendClokerFactory();
		sender = provider.produce();
		sender.send();
	}
}
