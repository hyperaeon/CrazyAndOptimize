package com.runoob.designpattern.state;

public class StopState implements State {

	@Override
	public void doAction(Context context) {
		System.out.println("Player is in stop state");
		context.setState(this);
	}
	
	public String toString() {
		return "stop state";
	}

}
