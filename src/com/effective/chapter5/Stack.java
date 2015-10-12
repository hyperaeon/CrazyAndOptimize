package com.effective.chapter5;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> {

	private E[] elements;

	private int size = 0;

	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	@SuppressWarnings("unchecked")
	public Stack() {
		elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public E pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		E result = elements[--size];
		elements[size] = null;
		return result;
	}

	public void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, (size << 1) + 1);
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		for (String arg : args) {
			stack.push(arg);
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop().toUpperCase());
		}
	}

}
