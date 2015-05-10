package com.crazy.chapter8;

import java.util.ArrayDeque;

public class ArrayQueueTest {

	public static void main(String[] args){
		ArrayDeque stack = new ArrayDeque<>();
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
