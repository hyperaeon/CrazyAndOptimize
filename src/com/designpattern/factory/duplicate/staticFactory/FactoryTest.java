package com.designpattern.factory.duplicate.staticFactory;

import com.designpattern.factory.duplicate.simpleFactory.Sender;

public class FactoryTest {

	public static void main(String[] args) {
		Sender sender = SendFactory.produceEmail();
		sender.send();
	}
}
