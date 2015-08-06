package com.algorithm.classic;

public class Factorial {

	public static void main(String[] args) {
		int total = 0;
		for (int i = 1; i <= 20; i++) {
			total += multiply(i);
		}
		System.out.println(total);
	}

	private static int multiply(int num) {
		if (num == 1) {
			return num;
		} else {
			return num * multiply(num - 1);
		}
	}
}
