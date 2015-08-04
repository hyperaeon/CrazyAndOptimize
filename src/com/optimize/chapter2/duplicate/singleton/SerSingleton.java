package com.optimize.chapter2.duplicate.singleton;

import java.io.Serializable;

public class SerSingleton implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SerSingleton() {
		System.out.println("SerSingleton");
	}

	private static SerSingleton instance = new SerSingleton();

	public static SerSingleton getInstance() {
		return instance;
	}

	public static void createString() {
		System.out.println("Create string in singleton");
	}

	public Object readResolve() {
		return instance;
	}
}
