package com.algorithm.classic;

public class PerfectNumber {

	public static void perfect(int number) {
		int sum = 0;
		for (int i = 1; i < number; i++) {
			if (number % i == 0) {
				sum += i;
			}
		}
		if (sum == number) {
			System.out.print(number + " ");
		}
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 1000; i++) {
			perfect(i);
		}
	}
}
