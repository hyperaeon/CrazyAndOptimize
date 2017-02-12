package com.designpattern.template.duplicate;

public class Minus extends AbstractCalculator {

	@Override
	protected int calculate(int num1, int num2) {
		return num1 - num2;
	}

}
