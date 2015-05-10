package com.optimize.chapter3;

public class CharTest {

	public static void main(String[] args) {
		String abc = "abc";
		int len = abc.length();
		if (abc.charAt(len - 1) == 'a') {
			System.out.println("true");
		}
		
		String orgStr = null;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10000; i++ ) {
			sb.append("abc");
		}
		orgStr = sb.toString();
		Long start = System.currentTimeMillis();
		int lenth = orgStr.length();
		for (int i = 0; i < 10000; i++) {
			if (orgStr.charAt(0) == 'a'
					&& orgStr.charAt(0) == 'b') {
				
			}
		}
		System.out.println(System.currentTimeMillis() - start);
		
		start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			if (orgStr.startsWith("abc") && orgStr.endsWith("abc")) {
			}
		}
		System.out.println(System.currentTimeMillis() - start);
	}
}
