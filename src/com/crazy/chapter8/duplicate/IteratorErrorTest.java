package com.crazy.chapter8.duplicate;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorErrorTest {

	public static void main(String[] args) {
		Collection<String> books = new HashSet<>();
		books.add("������Jave EE��ҵӦ��ʵս");
		books.add("���java����");
		books.add("���Android����");
		Iterator<String> it = books.iterator();
		while (it.hasNext()) {
			String book = it.next();
			System.out.println(book);
			if (book.equals("���Android����")) {
				books.remove(book);
			}
		}
		System.out.println(books);
	}
}
