package com.interview.chapter5;

import java.util.Scanner;

public class PrintResult {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		for (int i = 0; i < 2; i ++) {
			int n = s.nextInt();
			System.out.println("��" + (i + 1) + "������ƽ����" + p(n));
			System.out.println("��" + (i + 1) + "������������" + l(n));
		}
	}

	private static int l(int nextInt) {
		return nextInt * nextInt * nextInt;
	}

	private static int p(int nextInt) {
		return nextInt * nextInt ;
	}
}
