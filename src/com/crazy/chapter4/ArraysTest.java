package com.crazy.chapter4;

import java.util.Arrays;

public class ArraysTest {

	public static void main(String[] args) {
		int[] a = new int[]{3, 4, 5, 6};
		int[] b = new int[]{3, 4, 5, 6};
		System.out.println("a�����b�����Ƿ���ȣ�" + Arrays.equals(a, b));
		int[] c = Arrays.copyOf(a, 6);
		System.out.println("c�����Ԫ��Ϊ��" + Arrays.toString(c));
		Arrays.fill(c, 2, 4, 1);
		System.out.println("c�����Ԫ��Ϊ��" + Arrays.toString(c));
		Arrays.sort(c);
		System.out.println("c�����Ԫ��Ϊ��" + Arrays.toString(c));
	}
}
