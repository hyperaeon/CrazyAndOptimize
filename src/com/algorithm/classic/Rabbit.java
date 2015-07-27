package com.algorithm.classic;

public class Rabbit {

	public static int recursive(int i) {
		if (i == 1 || i == 2) {
			return 1;
		}
		return recursive(i - 1) + recursive(i - 2);
	}
	
	public static void main(String[] args) {
		for (int i = 1; i <= 20; i++) {
			System.out.println(recursive(i));
		}
	}
}
