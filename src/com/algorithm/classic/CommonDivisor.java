package com.algorithm.classic;

public class CommonDivisor {

	public static int divisor(int m, int n) {
		int temp;
		if (m < n) {
			temp = m;
			m = n;
			n = temp;
		}
		while (n != 0) {
			temp = m % n;
			m = n;
			n = temp;
		}
		return m;
	}
	
	public static void main(String[] args) {
		System.out.println(divisor(2, 13));
	}
}
