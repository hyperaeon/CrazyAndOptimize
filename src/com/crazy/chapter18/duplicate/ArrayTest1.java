package com.crazy.chapter18.duplicate;

import java.lang.reflect.Array;

public class ArrayTest1 {

	public static void main(String[] args) {
		try {
			Object arr = Array.newInstance(String.class, 10);
			Array.set(arr, 5, "fasdf");
			Array.set(arr, 6, "fsfwef");
			Object book1 = Array.get(arr, 5);
			Object book2 = Array.get(arr, 6);
			System.out.println(book1);
			System.out.println(book2);
		} catch (Throwable e) {
			System.err.println(e);
		}
	}
}
