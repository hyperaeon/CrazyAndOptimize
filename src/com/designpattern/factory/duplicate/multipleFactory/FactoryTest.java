package com.designpattern.factory.duplicate.multipleFactory;

import com.designpattern.factory.duplicate.simpleFactory.Sender;

public class FactoryTest {

	public static void main(String[] args) {
		SendFactory factory = new SendFactory();
		Sender sender = factory.produceEmail();
		sender.send();
	}
}
