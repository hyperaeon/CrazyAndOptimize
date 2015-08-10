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
	
	/**
	 * print 2demension int array.
	 * @param numbers
	 */
	public static void print2DIntArray(int[][] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[0].length; j++) {
				System.out.println(numbers[i][j] + " ");
			}
			System.out.println();
		}
	}
}
