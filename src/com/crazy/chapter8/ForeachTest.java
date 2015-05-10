package com.crazy.chapter8;

import java.util.Collection;
import java.util.HashSet;

public class ForeachTest {

	public static void main(String[] args){
		Collection books = new HashSet<>();
		books.add("java1");
		books.add("java2");
		books.add("java3");
		for(Object obj : books){
			String book = (String)obj;
			System.out.println(book);
			if(book.equals("java1")){
				books.remove(book);
			}
		}
		System.out.println(books);
	}
}
