package com.designpattern.template;

public abstract class AbstractCalculator {

	public final int calculate(String exp, String opt) {
		int arrayInt[] = split(exp, opt);
		return calculate(arrayInt[0], arrayInt[1]);
	}

	abstract public int calculate(int num1, int num2);
	
	private int[] split(String exp, String opt) {
		String[] arr = exp.split(opt);
		int arrayInt[] = new int[2];
		arrayInt[0] = Integer.valueOf(arr[0]);
		arrayInt[1] = Integer.valueOf(arr[1]);
		return arrayInt;
	}
}
