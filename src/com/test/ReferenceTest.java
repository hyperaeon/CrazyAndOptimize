package com.test;

public class ReferenceTest {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("a");
		StringBuffer sb2 = new StringBuffer("b");
		swapRef(sb, sb2);
		System.out.println(sb.toString());
		System.out.println(sb2.toString());
	}

	private static void swapRef(StringBuffer x, StringBuffer y) {
		y = x;
		System.out.println("x: " + x.toString());
		System.out.println("y: " + y.toString());
		
	}
}
