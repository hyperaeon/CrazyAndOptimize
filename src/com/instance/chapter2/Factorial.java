package com.instance.chapter2;

import java.math.BigDecimal;

public class Factorial {

	public static void main(String[] args) {
		BigDecimal total = new BigDecimal(0.0);
		BigDecimal factorial = new BigDecimal(1.0);
		int i = 1;
		while (i <= 20) {
			total = total.add(factorial);
			++i;
			factorial = factorial.multiply(new BigDecimal(1.0 / i));
		}
		System.out.println(total);
	}
}
