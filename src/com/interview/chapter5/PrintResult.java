package com.interview.chapter5;

import java.util.Scanner;

public class PrintResult {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		for (int i = 0; i < 2; i ++) {
			int n = s.nextInt();
			System.out.println("第" + (i + 1) + "个数的平方：" + p(n));
			System.out.println("第" + (i + 1) + "个数的立方：" + l(n));
		}
	}

	private static int l(int nextInt) {
		return nextInt * nextInt * nextInt;
	}

	private static int p(int nextInt) {
		return nextInt * nextInt ;
	}
}
