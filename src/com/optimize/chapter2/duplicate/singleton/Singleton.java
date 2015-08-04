package com.optimize.chapter2.duplicate.singleton;

public class Singleton {
	private static Singleton instance = new Singleton();

	private Singleton() {
		System.out.println("Singleton has been created");
	}

	public static Singleton getInstance() {
		return instance;
	}
}
