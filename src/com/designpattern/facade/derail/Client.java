package com.designpattern.facade.derail;

public class Client {

	public static void main(String[] args) {
		SwitchFacade facade = new SwitchFacade();
		facade.change(false);
		facade.change(true);
	}
}
