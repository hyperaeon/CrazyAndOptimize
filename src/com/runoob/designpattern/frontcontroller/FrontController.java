package com.runoob.designpattern.frontcontroller;

public class FrontController {

	private Dispatcher dispatcher;
	
	public FrontController() {
		dispatcher=  new Dispatcher();
	}
	
	private boolean isAuthenticUser() {
		System.out.println("User is authenticated successfully");
		return true;
	}
	
	private void trackRequest(String request) {
		System.out.println("Page request: " + request);
	}
	
	public void dispatcherRequest(String request) {
		trackRequest(request);
		if (isAuthenticUser()) {
			dispatcher.disptach(request);
		}
	}
}
