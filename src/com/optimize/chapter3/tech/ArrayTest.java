package com.optimize.chapter3.tech;

public class ArrayTest {

	private static int LIMIT = 1000000;

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int[] array = new int[LIMIT];
		int re = 0;
		for (int k = 0; k < 100; k++) {
			for (int i = 0; i < array.length; i++) {
				array[i] = i;
			}
		}
		for (int k = 0; k < 100; k++) {
			for (int i = 0; i < array.length; i++) {
				re = array[i];
			}
		}
		System.out.println("1D array waste: "
				+ (System.currentTimeMillis() - start) + "ms");
		
		start = System.currentTimeMillis();
		int[][] arrays = new int[1000][1000];
		re = 0;
		for (int k = 0; k < 100; k++) {
			for (int i = 0; i < arrays.length; i++) {
				for (int j = 0; j < arrays[0].length; j++) {
					arrays[i][j] = i;
				}
			}
		}
		for (int k = 0; k < 100; k++) {
			for (int i = 0; i < arrays.length; i++) {
				for (int j = 0; j < arrays[0].length; j++) {
					re = arrays[i][j];
				}
			}
		}
		System.out.println("2D array waste: "
				+ (System.currentTimeMillis() - start) + "ms");
	}
}
