package com.crazy.chapter8.duplicate.set;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {

	public static void main(String[] args) {
		LinkedHashSet<String> books = new LinkedHashSet<>();
		books.add("���java����");
		books.add("������java EE��ҵӦ��ʵս");
		System.out.println(books);
		books.remove("���java����");
		books.add("���java����");
		System.out.println(books);
	}
}
