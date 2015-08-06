package com.algorithm.classic;

public class NumeratorAndDenominator {

	public static void main(String[] args) {
		calculate();
	}

	private static void calculate() {
		int numerator = 2;
		int denominator = 1;
		double sum = 0;
		for (int i = 0; i < 20; i++) {
			sum += (double)numerator / denominator;
			System.out.print(numerator + "/" + denominator + " ");
			int tmp = denominator;
			denominator = numerator;
			numerator = tmp + numerator;
		}
		System.out.println();
		System.out.println(sum);
	}
}
