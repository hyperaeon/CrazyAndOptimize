package com.test;

public class StringReplaceTest {

	public static void main(String[] args) {
		String str = "Mdf%fsd%";
		str = str.replaceAll("%", "/%");
		System.out.println(str);
		
	}
}
