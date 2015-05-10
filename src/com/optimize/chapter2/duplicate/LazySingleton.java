package com.optimize.chapter2.duplicate;

public class LazySingleton {

	private static LazySingleton instance = null;
	
	private LazySingleton() {
		System.out.println("LazySingleton is created");
	}
	
	public static synchronized LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
}
