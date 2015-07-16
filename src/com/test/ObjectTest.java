package com.test;


public class ObjectTest {

	public static void main(String[] args) {
		String str = "dfsdfs";
		System.out.println(str.hashCode());
		swap(str);
		System.out.println(str);
		String s = "s";
		s = new String("dff");
	}
	
	public static void swap(String str) {
		System.out.println(str.hashCode());
		str = new String("abc");
		System.out.println(str.hashCode());
		System.out.println(str);
	}
}
