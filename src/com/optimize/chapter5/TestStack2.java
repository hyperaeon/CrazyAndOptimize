package com.optimize.chapter5;

import org.junit.Test;

public class TestStack2 {

	private int count = 0;
	
	public void recursion(long a, long b, long c) throws InterruptedException {
		long d = 0, e = 0, f = 0;
		count ++;
		recursion(a, b, c);
	}
	
	@Test
	public void testStack() {
		try {
			recursion(1L, 2L, 3L);
		} catch (Throwable e) {
			System.out.println("deep of stack is " + count);
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new TestStack2().testStack();
	}
}
