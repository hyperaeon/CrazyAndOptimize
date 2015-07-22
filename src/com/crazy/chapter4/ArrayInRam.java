package com.crazy.chapter4;

public class ArrayInRam {

	public static void main(String[] args) {
		int[] a = { 5, 7, 29 };
		int[] b = new int[4];
		System.out.println("数组b的长度：" + b.length);
		for (int i = 0, len = a.length; i < len; i++) {
			System.out.println(a[i]);
		}
		for (int i = 0, len = b.length; i < len; i++) {
			System.out.println(b[i]);
		}
		b = a;
		System.out.println("b数组的长度：" + b.length);
	}
}
