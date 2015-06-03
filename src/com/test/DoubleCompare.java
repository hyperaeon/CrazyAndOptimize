package com.test;

import java.math.BigDecimal;

public class DoubleCompare {

	public static void main(String[] args) {
		double d = 0.0;
		System.out.println(d == 0);
		BigDecimal b = new BigDecimal(-1);
		System.out.println(b.doubleValue() < -2);
	}
}
