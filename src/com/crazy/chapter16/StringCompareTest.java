package com.crazy.chapter16;

public class StringCompareTest {

	public static void main(String[] args){
		String s1 = "·è¿ñjava½²Òå";
		String s2 = "·è¿ñ";
		String s3 = "java½²Òå";
		String s4 = "java½²Òå";
		String s5 = s2 + s3;
		System.out.println(s1 == (s2 + s3));
		System.err.println("sdf");
		System.out.println(s3 == s4);
		System.out.println(s1 == s5);
	}
}
