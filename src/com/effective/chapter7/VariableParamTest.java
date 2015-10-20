package com.effective.chapter7;

import java.util.Arrays;

public class VariableParamTest {

	public static int sum(int... args) {
		int sum = 0;
		for (int i : args) {
			sum += i;
		}
		return sum;
	}

	public static int min(int... args) {
		if (args.length == 0) {
			throw new IllegalArgumentException("At least one parameter");
		}
		int min = args[0];
		for (int i = 1; i < args.length; i++) {
			if (min > args[i]) {
				min = args[i];
			}
		}
		return min;
	}

	public static int min(int firstArg, int... args) {
		int min = firstArg;
		for (int i : args) {
			if (min > i) {
				min = i;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		int[] digits = {3,2,34,5,65,3,6};
		System.out.println(Arrays.asList(digits));
		System.out.println(Arrays.toString(digits));
	}
}
