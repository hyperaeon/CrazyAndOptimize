package com.algorithm.classic;

public class Narcissus {

	public static boolean isNarcissus(int num) {
		int origin = num;
		int sin = 0;
		int total = 0;
		while (num != 0) {
			sin = num % 10;
			total += trip(sin);
			num = num / 10;
		}
		if (total == origin) {
			return true;
		}
		return false;
	}
	
	public static int trip(int num) {
		return num * num * num;
	}
	
	public static void main(String[] args) {
		for (int i = 100; i < 1000; i++) {
			if (isNarcissus(i)) {
				System.out.print(i + " ");
			}
		}
	}
}
