package com.designpattern.command;

public class CommandTest {

	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		Command command = new MyCommand(receiver);
		Invoker invoker = new Invoker(command);
		invoker.action();
		
		BeAttacked beAttacked = new BeAttacked();
		command = new AttackCommand(beAttacked);
		invoker = new Invoker(command);
		invoker.action();
	}
}
