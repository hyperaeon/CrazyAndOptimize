package com.optimize.chapter3;

public class SwitchTest {

	public static void main(String[] args) {
		int[] a = new int[]{0, 3, 6, 7, 8, 10, 16, 18, 44};
		Long start = System.currentTimeMillis();
		int re = 0;
		for (int i = 0; i < 10000000; i++) {
			re = arrayInt(a, i);
		}
		System.out.println("re: " + re);
		System.out.println("Time elapse: " + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			re = switchInt(i);
		}
		System.out.println("re: " + re);
		System.out.println("Time elapse: " + (System.currentTimeMillis() - start));
	}
	
	public static int switchInt(int z) {
		int i = z % 10 + 1;
		switch (i) {
		case 1: return 3;
		case 2: return 6;
		case 3: return 7;
		case 4: return 8;
		case 5: return 10;
		case 6: return 16;
		case 7: return 18;
		case 8: return 44;
//		default : return -1;
		}
		return -1;
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
