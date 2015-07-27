package com.algorithm.sort;

public final class SortUtils {

	/**
	 * swap data[i] and data[j].
	 * @param data
	 * @param i
	 * @param j
	 */
	public static void swap(int[] data, int i, int j) {
		if (i == j) {
			return;
		}
		data[i] = data[i] + data[j];
		data[j] = data[i] - data[j];
		data[i] = data[i] - data[j];
	}
	
	/**
	 * print the data in data[].
	 * @param data
	 */
	public static void printData(int[] data) {
		for (int d : data) {
			System.out.print(d + "\t");
		}
		System.out.println();
	}
}
