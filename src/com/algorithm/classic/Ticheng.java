package com.algorithm.classic;

import java.util.Scanner;

public class Ticheng {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double input = sc.nextDouble();
		double sum;
		if (input <= 100000) {
			sum = input * 0.1;
		} else if (input <= 200000) {
			sum = input * 0.075 + 10000;
		} else {
			sum = input * 0.01;
		}
		System.out.println("应发奖金：" + sum);
	}
}
