package com.crazy.chapter8.duplicate;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorTest {

	public static void main(String[] args) {
		Collection<String> books = new HashSet<>();
		books.add("轻量级Jave EE企业应用实战");
		books.add("疯狂java讲义");
		books.add("疯狂Android讲义");
		Iterator<String> it = books.iterator();
		while (it.hasNext()) {
			String book = it.next();
			System.out.println(book);
			if (book.equals("疯狂java讲义")) {
				it.remove();
			}
			book = "ceshi";
		}
		System.out.println(books);
	}
}
