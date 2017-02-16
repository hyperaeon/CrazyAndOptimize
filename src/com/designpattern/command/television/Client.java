package com.designpattern.command.television;


public class Client {

	public static void main(String[] args) {
		ReceiverTV receiver = new ReceiverTV();
		InvokerController invoker = new InvokerController();
		ICommand command = new ConcreteCommandOpen(receiver);
		invoker.addCommand(command);
		invoker.runCommand(command);
	}
}
