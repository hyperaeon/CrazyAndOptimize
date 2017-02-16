package com.designpattern.command;

public class AttackCommand implements Command {

	private BeAttacked beAttacked;
	
	public AttackCommand(BeAttacked beAttacked) {
		this.beAttacked = beAttacked;
	}
	
	@Override
	public void exe() {
		beAttacked.action();
	}

}
