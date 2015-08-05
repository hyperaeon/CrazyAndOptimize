package com.designpattern.strategy.duplicate;

public class StrategyTest {

	public static void main(String[] args) {
		String exp = "2+3";
		ICalculator cal = new Plus();
		System.out.println(cal.calculate(exp));
	}
}
