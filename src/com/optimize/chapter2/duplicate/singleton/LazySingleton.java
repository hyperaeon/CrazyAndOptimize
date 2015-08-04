package com.optimize.chapter2.duplicate.singleton;

public class LazySingleton {

	private static LazySingleton instance = null;

	private LazySingleton() {
		System.out.println("LazySingleton has been created");
	}

	public synchronized static LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
}
