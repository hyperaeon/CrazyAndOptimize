package com.interview.chapter12;

import java.math.BigInteger;

public class BigIntegerTest {

	public static void main(String[] args) {
		BigInteger one = new BigInteger("1");
		BigInteger two = new BigInteger("2");
		one.add(two);
		System.out.println(one);
		String i = "";
		System.out.println(i == i + 0);
	}
}
