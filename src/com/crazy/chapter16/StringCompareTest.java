package com.crazy.chapter16;

public class StringCompareTest {

	public static void main(String[] args){
		String s1 = "���java����";
		String s2 = "���";
		String s3 = "java����";
		String s4 = "java����";
		String s5 = s2 + s3;
		System.out.println(s1 == (s2 + s3));
		System.err.println("sdf");
		System.out.println(s3 == s4);
		System.out.println(s1 == s5);
	}
}
