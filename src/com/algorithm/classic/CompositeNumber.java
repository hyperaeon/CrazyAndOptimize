package com.algorithm.classic;

public class CompositeNumber {

	public static void main(String[] args) {
		composite();
		int[] data = {1, 9, 8, 7, 6, 0};
		composite(data);
	}

	public static void composite() {
		int i = 0;
		int j = 0;
		int k = 0;
		int total = 0;
		for (i = 1; i <= 4; i++) {
			for (j = 1; j <= 4; j++) {
				for (k = 1; k <= 4; k++) {
					if (i != j && j != k && i != k) {
						total++;
						System.out.print((i * 100 + j * 10 + k) + " ");
					}
				}
			}
		}
		System.out.println("组合数：" + total);
	}
	
	public static void composite(int[] data) {
		int i = 0;
		int j = 0;
		int k = 0;
		int total = 0;
		for (i = 0; i < data.length; i++) {
			for (j = 0; j < data.length; j++) {
				for (k = 0; k < data.length; k++) {
					if (i != j && j != k && i != k) {
						if (data[i] == 0) {
							continue;
						}
						total++;
						System.out.print((data[i] * 100 + data[j] * 10 + data[k]) + " ");
					}
				}
			}
		}
		System.out.println("组合数：" + total);
	}
}
