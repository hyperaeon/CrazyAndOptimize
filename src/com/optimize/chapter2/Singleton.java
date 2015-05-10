package com.optimize.chapter2;

public class Singleton {

	public static Singleton instance = new Singleton();

	private Singleton() {
//		System.out.println("Singleton has been created");
	}

	public static Singleton getInstance() {
		return instance;
	}

	public static void createString() {
//		System.out.println("createString has been created");
	}
}
