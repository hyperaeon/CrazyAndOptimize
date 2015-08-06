package com.crazy.chapter8.duplicate.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {

	public static void main(String[] args) {
		String[] books = { "java1", "java2" };
		List<String> booksList = new ArrayList<>();
		for (int i = 0; i < books.length; i++) {
			booksList.add(books[i]);
		}
		ListIterator<String> it = booksList.listIterator();
		while (it.hasNext()) {
			System.out.println(it.next());
			it.add("----------·Ö¸ô·û-----------");
		}
		while (it.hasPrevious()) {
			System.out.println(it.previous());
		}
	}
}
