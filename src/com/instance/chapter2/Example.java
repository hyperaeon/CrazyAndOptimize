package com.instance.chapter2;

import java.util.Scanner;

public class Example {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String password = sc.next();
		char[] chr = password.toCharArray();
		for (int i = 0; i < chr.length; i++) {
			chr[i] = (char) (chr[i] ^ 2000);
		}
		System.out.println(new String(chr));
	}
}
