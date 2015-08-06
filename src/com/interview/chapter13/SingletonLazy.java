package com.interview.chapter13;

public class SingletonLazy {
	private static SingletonLazy instance = null;

	private SingletonLazy() {

	}

	public static synchronized SingletonLazy getIntance() {
		if (instance == null) {
			instance = new SingletonLazy();
		}
		return instance;
	}

}
