package com.effective.chapter7;

public class AssertionTest {
	private int a = 2;

	private void sort(long[] a, int offset, int size) {
		assert a != null;
		assert offset >= 0 && offset <= a.length;
		assert size >= 0 && size <= a.length - offset;
		System.out.println("after assertion");
	}

	public static void main(String[] args) {
		AssertionTest test = new AssertionTest();
		long[] a = { 3, 2, 4 };
		test.sort(a, 0, 2);
		System.out.println(test.a);
	}

}
