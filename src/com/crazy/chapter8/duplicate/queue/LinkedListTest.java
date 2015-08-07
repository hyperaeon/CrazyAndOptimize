package com.crazy.chapter8.duplicate.queue;

import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<String> books = new LinkedList<String>();
		books.offer("java1");
		books.push("java2");
		books.addFirst("java3");
		for (int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i));
		}
		System.out.println(books.peekFirst());
		System.out.println(books.peekLast());
		System.out.println(books.pop());
		System.out.println(books);
		System.out.println(books.pollLast());
		System.out.println(books);
	}
}
