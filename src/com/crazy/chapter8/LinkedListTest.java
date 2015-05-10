package com.crazy.chapter8;

import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args){
		LinkedList books = new LinkedList<>();
		books.offer("java1");
		books.push("java2");
		System.out.println(books);
		books.offerFirst("java3");
		System.out.println(books);
		books.push("java4");
		System.out.println(books);
		for(Object str : books){
			System.out.println(str);
		}
		
	}
}
