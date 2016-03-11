package com.instance.chapter2;

public class VariableExchange {

	public static void main(String[] args) {
		long a = 2;
		long b = 3;
		a = a ^ b;
		b = b ^ a;
		a = a ^ b;
		System.out.println(a + " " + b);
		long c = 4;
		long d = 5;
		System.out.println(c ^ d ^ c);
	}
}
