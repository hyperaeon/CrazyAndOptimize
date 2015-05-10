package com.optimize.chapter2;

import java.io.Serializable;

public class SerSingleton implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;

	private SerSingleton() {
		System.out.println("Singleton is create");
		name = "SerSingleton";
	}

	private static SerSingleton instance = new SerSingleton();

	public static SerSingleton getInstance() {
		return instance;
	}

	public static void createString() {
		System.out.println("createString is create");
	}

	private Object readResolve() {
		return instance;
	}
}
