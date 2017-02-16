package com.designpattern.command.television;

public class ConcreteCommandChange implements ICommand {

	private ReceiverTV receiver;
	
	public ConcreteCommandChange(ReceiverTV receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public void execute() {
		receiver.actionChange();
	}

}
