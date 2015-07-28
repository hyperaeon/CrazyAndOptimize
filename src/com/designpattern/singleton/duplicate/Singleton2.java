package com.designpattern.singleton.duplicate;

public class Singleton2 {

	private static class SingletonFacotry {
		private static Singleton2 instance = new Singleton2();
	}

	public static Singleton2 getInstance() {
		return SingletonFacotry.instance;
	}
}
