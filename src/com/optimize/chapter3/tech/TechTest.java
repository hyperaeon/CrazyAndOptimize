package com.optimize.chapter3.tech;

public class TechTest {

	private static int LIMIT = 100000000;

	public static int c = 0;
	public static void main(String[] args) {
		int a = 0;
		long start = System.currentTimeMillis();
		for (int i = 0; i < LIMIT; i++) {
			try {
				a++;
			} catch (Exception e) {

			}
		}
		System.out.println("try-catch in of body waste: "
				+ (System.currentTimeMillis() - start) + "ms");
		start = System.currentTimeMillis();
		try {
			for (int i = 0; i < LIMIT; i++) {
				a++;
			}
		} catch (Exception e) {
		}
		System.out.println("try-catch out of body waste: "
				+ (System.currentTimeMillis() - start) + "ms");
		start = System.currentTimeMillis();
		int b = 0;
		for (int i = 0; i < LIMIT; i++) {
			b++;
		}
		System.out.println("local variable waste: "
				+ (System.currentTimeMillis() - start) + "ms");
		start = System.currentTimeMillis();
		for (int i = 0; i < LIMIT; i++) {
			c++;
		}
		System.out.println("static variable waste: "
				+ (System.currentTimeMillis() - start) + "ms");
		
		start = System.currentTimeMillis();
		long d = 100;
		for (int i = 0; i < LIMIT; i++) {
			d *= 2;
			d /= 2;
		}
		System.out.println("non bit cal waste: "
				+ (System.currentTimeMillis() - start) + "ms");
	
		start = System.currentTimeMillis();
		long e = 100;
		for (int i = 0; i < LIMIT; i++) {
			e <<= 2;
			e >>= 2;
		}
		System.out.println("bit cal waste: "
				+ (System.currentTimeMillis() - start) + "ms");
	}
}
