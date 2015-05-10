package com.optimize.chapter2;

public class LazySingleton {

	private static LazySingleton instance = null;

	private LazySingleton() {
//		System.out.println("LazySingleton has been created");
	}

	public static synchronized LazySingleton getInstance() {
		if (instance == null) {
			return new LazySingleton();
		}
		return instance;
	}
}
