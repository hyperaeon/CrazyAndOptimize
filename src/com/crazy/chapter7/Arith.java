package com.crazy.chapter7;

import java.math.BigDecimal;

public class Arith {

	private static final int DEF_DIV_SCALE = 10;

	private Arith() {
	}

	public static double add(double v1, double v2) {
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		return b1.add(b2).doubleValue();
	}

	public static double sub(double v1, double v2) {
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		return b1.subtract(b2).doubleValue();
	}

	public static double mul(double v1, double v2) {
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		return b1.multiply(b2).doubleValue();
	}

	public static double div(double v1, double v2) {
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		return b2.divide(b2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public static void main(String[] args) {
		System.out.println("0.05 + 0.01 = " + Arith.add(0.05, 0.01));
		System.out.println("1.0 - 0.42 = " + Arith.add(1.0, 0.42));
		System.out.println("4.015 * 100 = " + Arith.add(4.015, 100));
		System.out.println("123.3 / 100 = " + Arith.add(123.3, 100));
	}
}
