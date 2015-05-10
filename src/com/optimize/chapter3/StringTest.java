package com.optimize.chapter3;

public class StringTest {

	public static void main(String[] args) {
		String str = "";
		for (int i = 0; i < 10000; i++) {
			str = str + i;
		}
	}
}
