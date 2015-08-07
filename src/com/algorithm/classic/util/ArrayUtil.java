package com.algorithm.classic.util;

public final class ArrayUtil {

	private ArrayUtil() {

	}

	/**
	 * print int array.
	 * 
	 * @param number
	 */
	public static void printIntArray(int[] number) {
		for (int n : number) {
			System.out.print(n + " ");
		}
	}

	/**
	 * print String array.
	 * 
	 * @param strings
	 */
	public static void printStringArray(String[] strings) {
		for (String n : strings) {
			System.out.print(n + " ");
		}
	}
}
