package com.algorithm.classic;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			if (judgePalindrome2(s.nextInt())) {
				System.out.println("Palindrome");
			} else {
				System.out.println("Non-Palindrome");
			}
		}
	}

	private static boolean judgePalindrome(int num) {
		int len = 0;
		int tmp = num;
		while (tmp != 0) {
			len++;
			tmp /= 10;
		}
		int[] arr = new int[len];
		len = 0;
		while (num != 0) {
			arr[len++] = num % 10;
			num /= 10;
		}
		for (int i = 0; i < len >> 1; i++) {
			if (arr[i] != arr[len - 1 - i]) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean judgePalindrome2(int num) {
		String str = String.valueOf(num);
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] != ch[ch.length - 1 -i]) {
				return false;
			}
		}
		return true;
	}
}
