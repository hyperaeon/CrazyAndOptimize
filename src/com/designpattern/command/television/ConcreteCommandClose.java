package com.designpattern.command.television;

public class ConcreteCommandClose implements ICommand {

	private ReceiverTV receiver;
	
	public ConcreteCommandClose(ReceiverTV receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public void execute() {
		receiver.actionClose();
	}

}
