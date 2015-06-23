package com.crazy.chapter7;

public class CompareToTest {

	public static void main(String[] args) {
		String s1 = "abcdefghijklmn";
		String s2 = "abcdefghij";
		String s3 = "abcdefghijalmn";
		System.out.println("s1.compareTo(s2): " + s1.compareTo(s2));
		System.out.println("s1.compareTo(s3): " + s1.compareTo(s3));
	}
}
