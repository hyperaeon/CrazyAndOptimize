package com.algorithm.classic;

public class MonkeyPeach {

	public static void main(String[] args) {
		System.out.println(calculate(1));
	}
	
	private static int calculate(int day) {
		if (day == 10) {
			return 1;
		}
		return (calculate(day + 1) + 1) << 1;
	}
}
