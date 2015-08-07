package com.interview.chapter12;

public class Foo {

	public static void main(String[] args) {
		StringBuffer a = new StringBuffer("a");
		StringBuffer b = new StringBuffer("b");
		operate(a, b);
		System.out.println(a + ", " + b);
	}

	private static void operate(StringBuffer a, StringBuffer b) {
		a.append(b);
		b = a;
		
	}
}
