package com.crazy.chapter8.duplicate;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class ForeachTest {

	public static void main(String[] args) {
		Collection<String> books = new HashSet<>();
		books.add(new String("轻量级Jave EE企业应用实战"));
		books.add(new String("疯狂java讲义"));
		books.add(new String("疯狂Android讲义"));
		for (String book : books) {
			System.out.println(book);
			if (book.equals("疯狂Android讲义")) {
				books.remove(book);
			}
		}
		System.out.println(books);
	}
}
