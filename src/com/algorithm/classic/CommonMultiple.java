package com.algorithm.classic;

public class CommonMultiple {

	public static int leastCommonMultiple(int m, int n) {
		return m * n / CommonDivisor.divisor(m, n);
	}
	
	public static void main(String[] args) {
		System.out.println(CommonMultiple.leastCommonMultiple(30, 2));
	}
}
