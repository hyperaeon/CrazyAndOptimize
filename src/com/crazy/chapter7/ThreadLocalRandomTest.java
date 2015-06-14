package com.crazy.chapter7;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomTest {

	public static void main(String[] args) {
		ThreadLocalRandom rand = ThreadLocalRandom.current();
		int val1 = rand.nextInt(4, 10);
		double val2 = rand.nextDouble(2.0, 10.0);
		System.out.println(val1);
		System.out.println(val2);
	}
}
