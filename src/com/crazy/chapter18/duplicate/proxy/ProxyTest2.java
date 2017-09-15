package com.crazy.chapter18.duplicate.proxy;

public class ProxyTest2 {

	public static void main(String[] args) throws Exception {
		Dog target = new GunDog();
		Dog dog = (Dog) MyProxyFactory.getProxy(target);
		dog.info();
		dog.run();
	}
}
