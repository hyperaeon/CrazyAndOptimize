package com.optimize.chapter2.duplicate.singleton;

public class StaticSingleton {

	private StaticSingleton() {
		System.out.println("StaticSingleton has been created");
	}

	private static class SingletonHolder {
		private static StaticSingleton instance = new StaticSingleton();
	}

	public static StaticSingleton getInstance() {
		return SingletonHolder.instance;
	}
}
