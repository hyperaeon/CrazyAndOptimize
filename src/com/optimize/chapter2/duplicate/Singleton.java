package com.optimize.chapter2.duplicate;

public class Singleton {

	private static Singleton instance = new Singleton();
	
	private Singleton() {
		System.out.println("Singleton is created");
	}
	
	public static Singleton getInstance() {
		return instance;
	}
	
	public static void createString() {
		System.out.println("create String in Singleton");
	}
}
