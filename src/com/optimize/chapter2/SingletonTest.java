package com.optimize.chapter2;

public class SingletonTest extends Thread {

	public static void main(String[] args) {
		SingletonTest test = new SingletonTest();
		test.start();
	}
	
	public void run() {
		Long start = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++) {
			Singleton.getInstance();
		}
		System.out.println("Create Singleton waste " + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++) {
			LazySingleton.getInstance();
		}
		System.out.println("Create LazySingleton waste " + (System.currentTimeMillis() - start));
	}
}
