package com.crazy.chapter8.duplicate.list;

import java.util.Stack;

public class VectorTest {

	public static void main(String[] args) {
		Stack<String> v = new Stack<String>();
		v.add("java1");
		v.add("java2");
		v.add("java3");
		System.out.println(v);
		System.out.println(v.peek());
		System.out.println(v);
		System.out.println(v.pop());
		System.out.println(v);
	}
}
