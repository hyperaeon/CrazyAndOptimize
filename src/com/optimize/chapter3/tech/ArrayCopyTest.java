package com.optimize.chapter3.tech;

public class ArrayCopyTest {

	public static void main(String[] args) {
		int size = 1000000;
		int[] array = new int[size];
		int[] arraydst = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			System.arraycopy(array, 0, arraydst, 0, size);
		}
		System.out.println("ArrayCopy waste : "
				+ (System.currentTimeMillis() - start) + "ms");

		start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < array.length; j++) {
				arraydst[j] = array[j];
			}
		}
		System.out.println("Customize waste : "
				+ (System.currentTimeMillis() - start) + "ms");
	}
}
