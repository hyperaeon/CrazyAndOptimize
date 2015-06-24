package com.crazy.chapter8.duplicate.queue;

import java.util.ArrayDeque;

public class ArrayDequeTest {

	public static void main(String[] args) {
		ArrayDeque<String> stack = new ArrayDeque<String>();
		stack.push("java1");
		stack.push("java2");
		stack.push("java3");
		System.out.println(stack);
		System.out.println(stack.peek());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
	}
}
