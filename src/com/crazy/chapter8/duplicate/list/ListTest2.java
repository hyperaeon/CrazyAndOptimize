package com.crazy.chapter8.duplicate.list;

import java.util.ArrayList;
import java.util.List;

class A {
	public boolean equals(Object obj) {
		return true;
	}
}

public class ListTest2 {

	public static void main(String[] args) {
		List books = new ArrayList<>();
		books.add("java1");
		books.add("java2");
		books.add("java3");
		System.out.println(books);
		books.remove(new A());
		System.out.println(books);
		books.remove(new A());
		System.out.println(books);
	}
}
