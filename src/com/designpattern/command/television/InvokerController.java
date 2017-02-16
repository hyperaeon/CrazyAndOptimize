package com.designpattern.command.television;

import java.util.ArrayList;
import java.util.List;

public class InvokerController {

	private List<ICommand> commandList = new ArrayList<ICommand>();
	
	public InvokerController() {
	}
	
	public void addCommand(ICommand command) {
		commandList.add(command);
	}
	
	
	public void runCommand(ICommand command) {
		if (commandList.contains(command)) {
			command.execute();
		}
	}
}
