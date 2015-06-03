package com.test;

import java.math.BigDecimal;

public class StringBuilderTest {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		BigDecimal bd = new BigDecimal("2.22");
		sb.append(bd);
		System.out.println(sb.toString());
	}
}
