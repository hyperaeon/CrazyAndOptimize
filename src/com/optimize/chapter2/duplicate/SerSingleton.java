package com.optimize.chapter2.duplicate;

import java.io.Serializable;

public class SerSingleton implements Serializable {

	String name;
	
	private SerSingleton() {
		System.out.println("Singleton is created");
		name = "SerSingleton";
	}
	
	private static SerSingleton instance = new SerSingleton();
	
	public static SerSingleton getInstance() {
		return instance;
	}
	
	public static void createString() {
		System.out.println("createString in Singleton");
	}
	
	private Object readResolve() {
		return instance;
	}
}
