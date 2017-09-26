package com.runoob.designpattern.proxy;

public class ProxyPatternDemo {

	public static void main(String[] args) {
		Image image = new ProxyImage("et.jpg");
		image.display();
		System.out.println("");
		
		image.display();
	}
}
