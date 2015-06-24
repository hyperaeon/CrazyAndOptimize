package com.crazy.chapter8.duplicate.list;

import java.util.ArrayList;
import java.util.List;


public class ListTest {

	public static void main(String[] args) {
		List<String> books = new ArrayList<>();
		books.add("java1");
		books.add("java2");
		books.add("java3");
		System.out.println(books);
		
		books.add(1, "java4");
		for (int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i));
		}
		books.remove(2);
		System.out.println(books);
		System.out.println(books.indexOf(new String("java4")));
		books.set(1, new String("java2"));
		System.out.println(books);
		System.out.println(books.subList(1, 2));
	}
}
