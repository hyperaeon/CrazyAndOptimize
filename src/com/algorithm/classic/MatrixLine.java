package com.algorithm.classic;

public class MatrixLine {

	public static void main(String[] args) {
		System.out.println(calculate());
	}

	public static int calculate() {
		int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j) {
					sum += arr[i][j];
				}
			}
		}
		return sum;
	}
}
