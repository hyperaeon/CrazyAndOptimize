package com.optimize.chapter5;

import org.junit.Test;

public class TestStack {

	private int count = 0;

	public void recursion() {
		count++;
		recursion();
	}

	@Test
	public void testStack() {
		try {
			recursion();
		} catch (Throwable e) {
			System.out.println("deep of stack is " + count);
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new TestStack().testStack();
	}
}
