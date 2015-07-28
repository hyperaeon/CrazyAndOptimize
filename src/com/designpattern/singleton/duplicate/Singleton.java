package com.designpattern.singleton.duplicate;

public class Singleton {

	private static Singleton instance = null;

	private Singleton() {

	}

	public synchronized static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	public static Singleton getInstance2() {
		if (instance == null) {
			synchronized(instance) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	public Object readResolve() {
		return instance.readResolve();
	}
}
