package com.algorithm.classic;

import java.util.Scanner;

public class JudgeNumber {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
//			printInfor(s.next());
			printInforFromInt(s.nextInt());
		}
	}

	/**
	 * print from string number.
	 * @param num
	 */
	private static void printInfor(String num) {
		char[] c = num.toCharArray();
		int len = c.length;
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = Integer.valueOf(String.valueOf(c[i]));
		}
		System.out.println(len + "位数 ");
		int tmp = 0;
		for (int i = 0; i < len >> 1; i++) {
			tmp = arr[i];
			arr[i] = arr[len - i - 1];
			arr[len - i - 1] = tmp;
		}
		System.out.println("after reverse in printInfor");
		printArray(arr);
	}

	/**
	 * print from int number.
	 * @param num
	 */
	private static void printInforFromInt(int num) {
		int len = 0;
		int tmp = num;
		while (tmp != 0) {
			len++;
			tmp /= 10;
		}
		int[] a = new int[len];
		len = 0;
		while (num != 0) {
			a[len++] = num % 10;
			num /= 10;
		}
		System.out.println("after reverse in printInforFromInt");
		printArray(a);
	}
	
	private static void printArray(int[] arr) {
		for (int a : arr) {
			System.out.print(a + " ");
		}
	}
}
