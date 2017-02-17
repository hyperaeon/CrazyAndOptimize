package com.designpattern.proxy.instance;

public class Client {

	public static void main(String[] args) {
		Weather proxy = new ProxyWeather();
		String report = proxy.display("beijing");
		System.out.println(report);
		
		
	}
}
