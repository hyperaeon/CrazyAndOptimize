package com.test.spring.aop;

public class GreetingImpl {

	private String test;
	
	public GreetingImpl() {
		
	}
	
	public GreetingImpl(String test) {
		this.test = test;
	}
	
	public void sayHello(String some) {
		System.out.println("say:" + test);
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	
}
