package com.crazy.chapter6;

public class StringJoinTest {

	public static void main(String[] args){
		String s1 = "·è¿ñjava";
		String s2 = "·è¿ñ" + "java";
		final String st1 = "·è¿ñ";
		final String st2 = "java";
		String s3 = st1 + st2;
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
	}
}
