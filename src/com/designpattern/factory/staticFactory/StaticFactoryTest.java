package com.designpattern.factory.staticFactory;

import com.designpattern.factory.simpleFactory.Sender;

public class StaticFactoryTest {

	public static void main(String[] args) {
		Sender sender = SendFactory.produceMail();
		sender.send();
	}
}
