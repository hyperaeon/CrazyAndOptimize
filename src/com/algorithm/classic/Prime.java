package com.algorithm.classic;

public class Prime {

	public static boolean isPrime(int j) {
		for (int i = 2; i < Math.sqrt(j); i++) {
			if (j % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int count = 0;
		for (int i = 101; i < 200; i++) {
			if (isPrime(i) == true) {
				System.out.print(i + " ");
				count++;
			}
		}
		System.out.println();
		System.out.println("����������" + count);

	}
}
