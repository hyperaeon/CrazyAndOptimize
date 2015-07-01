package com.designpattern.factory.multipleFactory;

import com.designpattern.factory.simpleFactory.Sender;

public class MultipleFactoryTest {

	public static void main(String[] args) {
		SendFactory factory = new SendFactory();
		Sender sender = factory.produceMail();
		sender.send();
	}
}
