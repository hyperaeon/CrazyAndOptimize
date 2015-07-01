package com.interview.chapter12;

import java.util.Arrays;

public class DominateStatistic2 {

	public static void main(String[] args) {
		int[] ints = { 3, 2, 3, 3, 0, 2, 3 };
		long start = System.nanoTime();
		System.out.println(judge(ints));
		System.out.println("Spend: " + (System.nanoTime() - start));
	}

	public static int judge(int[] ints) {
		Arrays.sort(ints);
		int counter = 1;
		for (int i = 0; i < (ints.length - 1); i++) {
			if (ints[i] == ints[i + 1]) {
				counter++;
				if ((double) counter / ints.length > 0.5) {
					return ints[i];
				}
			} else {
				counter = 1;
			}
		}
		return -1;
	}
}
