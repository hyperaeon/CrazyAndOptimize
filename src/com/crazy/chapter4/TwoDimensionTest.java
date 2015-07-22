package com.crazy.chapter4;

public class TwoDimensionTest {

	public static void main(String[] args) {
		int[][] a;
		a = new int[4][];
		for (int i = 0, len = a.length; i < len; i++) {
			System.out.println(a[i]);
		}
		a[0] = new int[2];
		a[0][1] = 6;
		for (int i = 0, len = a[0].length; i < len; i++) {
			System.out.println(a[0][i]);
		}
	}
}
