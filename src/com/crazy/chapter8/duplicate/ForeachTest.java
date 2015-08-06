package com.crazy.chapter8.duplicate;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class ForeachTest {

	public static void main(String[] args) {
		Collection<String> books = new HashSet<>();
		books.add(new String("������Jave EE��ҵӦ��ʵս"));
		books.add(new String("���java����"));
		books.add(new String("���Android����"));
		for (String book : books) {
			System.out.println(book);
			if (book.equals("���Android����")) {
				books.remove(book);
			}
		}
		System.out.println(books);
	}
}
