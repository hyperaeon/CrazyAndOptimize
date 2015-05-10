package com.optimize.chapter2;

public class StaticSingleton {

	private StaticSingleton() {
		System.out.println("StaticSingleton has been created");
	}
	
	public static StaticSingleton getInstance() {
		return SingletonHolder.instance;
	}
	
	private static class SingletonHolder {
		private static StaticSingleton instance = new StaticSingleton();
	}
}
