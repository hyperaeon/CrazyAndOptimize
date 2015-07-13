package com.designpattern.proxy;

public class Proxy implements Sourceable {

	private Source source;
	
	public Proxy() {
		super();
		this.source = new Source();
	}
	
	@Override
	public void method() {
		before();
		source.method();
		after();
	}

	private void before() {
		System.out.println("Before proxy!");
	}
	
	private void after() {
		System.out.println("After Proxy!");
	}
}
