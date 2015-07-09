package com.designpattern.singleton;

public class LazySingleton {

	private static LazySingleton instance = null;

	private LazySingleton() {
	}

	public static synchronized LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}

	public static LazySingleton getInstance2() {
		if (instance == null) {
			synchronized (instance) {
				instance = new LazySingleton();
			}
		}
		return instance;
	}

	public Object readResolve() {
		return instance;
	}
}
