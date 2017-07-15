package com.optimize.chapter5.duplicate;

public class TestStack {

	private static int count = 0;
	
	private static void recursion() {
		count++;
		recursion();
	}
	
	private static void testStack() {
		try {
			recursion();
		} catch (Throwable e) {
			System.out.println("deep of stack is " + count);
			e.printStackTrace();
		}
	}
	
	private static void recursion(long a, long b, long c) throws InterruptedException {
		long d = 0, e = 0, f = 0;
		count++;
		recursion(a, b, c);
	}
	
	private static void testStack2() {
		try {
			recursion(1, 2, 3);
		} catch (Throwable e) {
			System.out.println("deep of stack is " + count);
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		testStack();
		testStack2();
	}
}
