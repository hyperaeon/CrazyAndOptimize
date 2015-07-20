package com.designpattern.template;

public class TemplateTest {

	public static void main(String[] args) {
		String exp = "9+9";
		AbstractCalculator cal = new Plus();
		int result = cal.calculate(exp, "\\+");
		System.out.println(result);
	}
}
