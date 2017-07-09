package com.effective.duplicate.chapter2;

public class AutoboxTest {

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		Long sum = 0L;
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		long time2 = System.currentTimeMillis();
		System.out.println("waste :" + (time2 - time));
		System.out.println(sum);
		time = System.currentTimeMillis();
		long sum2 = 0;
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			sum2 += i;
		}
		time2 = System.currentTimeMillis();
		System.out.println("waste :" + (time2 - time));
		System.out.println(sum2);
	}
}
