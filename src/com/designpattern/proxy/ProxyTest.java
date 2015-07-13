package com.designpattern.proxy;

public class ProxyTest {

	public static void main(String[] args) {
		Sourceable proxy = new Proxy();
		proxy.method();
	}
}
