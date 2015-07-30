package com.algorithm.classic;

public class Squart {

	public static void main(String[] args) {
		for (int i = 1; i <= 1000000; i++) {
			if (Math.floor(Math.sqrt(i + 100)) == Math.sqrt(i + 100)
					&& Math.floor(Math.sqrt(i + 168)) == Math.sqrt(i + 168)) {
				System.out.print(i + " ");
			}
		}
	}
}
