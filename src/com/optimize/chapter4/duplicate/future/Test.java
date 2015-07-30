package com.optimize.chapter4.duplicate.future;

public class Test {

	public static void main(String[] args) {
		char[] value = new char[6];
		value[0] = 'f';
		value[1] = 'w';
		String str = "abcd";
		str.getChars(0, 4, value, 2);
		System.out.println(value);
	}
}
