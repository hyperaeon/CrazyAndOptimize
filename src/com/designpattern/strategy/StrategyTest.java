package com.designpattern.strategy;

public class StrategyTest {

	public static void main(String[] args) {
		String abc = "2+8";
		ICalculator cal = new Plus();
		int result = cal.calculate(abc);
		System.out.println(result);
	}
}
