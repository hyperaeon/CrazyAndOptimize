package com.optimize.chapter3;

public class SwitchArrayTest {

	public static void main(String[] args) {
		int[] a = new int[]{0, 3, 6, 7, 8, 10, 16, 18, 44};
		Long start = System.currentTimeMillis();
		int re = 0;
		for (int i = 0; i < 10000000; i++) {
			re = arrayInt(a, i);
		}
		System.out.println("re: " + re);
		System.out.println("Time elapse: " + (System.currentTimeMillis() - start));
	}
	
	public static int arrayInt(int[] a, int z) {
		int i = z % 10 + 1;
		if (i > 7 || i < 1 ) {
			return -1;
		} else {
			return a[i];
		}
	}
}
