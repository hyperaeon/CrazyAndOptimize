package com.designpattern.command.duplicate;

public class CommandTest {

	public static void main(String[] args) {
		Receiver r = new Receiver();
		MyCommand c = new MyCommand(r);
		Invoker i = new Invoker(c);
		i.action();
	}
}
