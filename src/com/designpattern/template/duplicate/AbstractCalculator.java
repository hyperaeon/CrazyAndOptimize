package com.designpattern.template.duplicate;

public abstract class AbstractCalculator {

	public final int calculate(String exp, String opt) {
		int[] array = split(exp, opt);
		return calculate(array[0], array[1]);
	}

	abstract protected int calculate(int num1, int num2);

	public int[] split(String exp, String opt) {
		String[] str = exp.split(opt);
		int[] arrInt = new int[str.length];
		arrInt[0] = Integer.parseInt(str[0]);
		arrInt[1] = Integer.parseInt(str[1]);
		return arrInt;
	}
}
