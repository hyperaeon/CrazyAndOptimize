package com.crazy.chapter8;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {

	public static void main(String[] args){
		LinkedHashSet<String> books = new LinkedHashSet<>();
		books.add("java1");
		books.add("java2");
		System.out.println(books);
		books.remove("java1");
		books.add("java1");
		System.out.println(books);
	}
}
