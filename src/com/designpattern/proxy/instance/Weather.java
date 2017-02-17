package com.designpattern.proxy.instance;

public interface Weather {

	public void request(String city);
	
	public String display(String city);
	
	public boolean isValidCity(String city);
}
