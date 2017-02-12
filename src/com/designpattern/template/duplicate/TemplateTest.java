package com.designpattern.template.duplicate;

public class TemplateTest {

	public static void main(String[] args) {
		String exp = "9+9";
		AbstractCalculator cal = new Plus();
		System.out.println(cal.calculate(exp, "\\+"));
		
		exp = "100-30";
		cal = new Minus();
		System.out.println(cal.calculate(exp, "\\-"));
	}
}
