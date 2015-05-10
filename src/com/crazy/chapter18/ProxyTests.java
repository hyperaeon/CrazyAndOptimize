package com.crazy.chapter18;

public class ProxyTests {

	public static void main(String[] args) throws Exception  {
		Dog target = new GunDog();
		Dog dog = (Dog) MyProxyFactorys.getProxy(target);
		dog.info();
		dog.run();

	}
}
