package com.crazy.chapter6;

public class StringJoinTest {

	public static void main(String[] args){
		String s1 = "���java";
		String s2 = "���" + "java";
		final String st1 = "���";
		final String st2 = "java";
		String s3 = st1 + st2;
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
	}
}
