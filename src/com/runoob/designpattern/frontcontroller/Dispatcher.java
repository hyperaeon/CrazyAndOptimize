package com.runoob.designpattern.frontcontroller;

public class Dispatcher {

	private StudentView studentView;
	
	private HomeView homeView;
	
	public Dispatcher() {
		studentView = new StudentView();
		homeView = new HomeView();
	}
	
	
	public void disptach(String request) {
		if (request.equalsIgnoreCase("STUDENT")) {
			studentView.show();
		} else {
			homeView.show();
		}
	}
}
