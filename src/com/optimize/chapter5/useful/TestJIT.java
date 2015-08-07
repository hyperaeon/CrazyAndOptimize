package com.optimize.chapter5.useful;

public class TestJIT {

	static long i = 0;

	public static void testJIT() {
		i++;
	}

	public static void main(String[] args) {
		for (int j = 0; j < 1501; j++) {
			testJIT();
		}
		long end = System.currentTimeMillis();
	}
}
