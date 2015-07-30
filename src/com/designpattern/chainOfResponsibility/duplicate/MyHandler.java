package com.designpattern.chainOfResponsibility.duplicate;

public class MyHandler extends AbstractHandler implements Handler {

	private String name;

	public MyHandler(String name) {
		this.name = name;
	}

	@Override
	public void operation() {
		System.out.println(name + "deal");
		if (getHandler() != null) {
			getHandler().operation();
		}
	}

}
