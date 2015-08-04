package com.algorithm.classic;

public class NineNine {

	public static void main(String[] args) {
		matrix();
		downTrangle();
		upTrangle();
	}


	private static void matrix() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.print(i * j + " ");
			}
			System.out.println();
		}
	}

	private static void downTrangle() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i * j + " ");
			}
			System.out.println();
		}
	}
	
	private static void upTrangle() {
		for (int i = 1; i <= 9; i++) {
			for (int j = i; j <= 9; j++) {
				System.out.print(i * j + " ");
			}
			System.out.println();
		}
	}
}
