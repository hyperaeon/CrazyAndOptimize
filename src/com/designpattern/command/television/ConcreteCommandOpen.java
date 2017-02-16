package com.designpattern.command.television;

public class ConcreteCommandOpen implements ICommand {

	private ReceiverTV receiver;
	
	public ConcreteCommandOpen(ReceiverTV receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public void execute() {
		receiver.actionOpen();
	}

}
