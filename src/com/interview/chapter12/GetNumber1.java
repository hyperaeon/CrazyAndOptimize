package com.interview.chapter12;

public class GetNumber1 {

	static String s = "323sdsadfasdfsd8sdfsf0sdfsdf898skfw03sdfsf";

	public static void main(String[] args) {
		String a = s.replaceAll("[^0-9]", "");
		System.out.println(a);
	}
}
