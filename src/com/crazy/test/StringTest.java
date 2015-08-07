package com.crazy.test;

public class StringTest {

	public static void main(String[] args) {
		String str = "abc";
		System.out.println(str.concat("def"));
		
		String strs = "a;b,c:d";
		String[] arr = strs.split("[;|,|:]");
		for (String ar : arr) {
			System.out.println(ar.toString());
		}
	}
}
