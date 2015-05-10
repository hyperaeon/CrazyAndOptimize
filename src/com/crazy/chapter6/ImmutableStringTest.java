package com.crazy.chapter6;

public class ImmutableStringTest {

	public static void main(String[] args){
		String str1 = "Hello";
		String str2 = "Hello";
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
	}
}
