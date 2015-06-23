package com.interview.chapter5;

import java.util.Scanner;

public class MultipleTwo {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			charge(s.nextInt());
		}
	}

	private static void charge(int nextInt) {
		if (((nextInt - 1) & nextInt) == 0 && (nextInt != 0)) {
			System.out.println(nextInt + "是2的阶");
		}
		else {
			System.out.println(nextInt + "不是2的阶");
		}
	}
}
