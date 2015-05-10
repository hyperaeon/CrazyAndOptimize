package com.crazy.chapter8;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorTest {

	public static void main(String[] args) {
		Collection books = new HashSet<>();
		books.add("java1");
		books.add("java2");
		books.add("java3");
		
		Iterator it = books.iterator();
		while(it.hasNext()){
			String book = (String)it.next();
			if(book.equals("java2")){
				it.remove();
			}
			book = "java4";
		}
		System.out.println(books);
	}
	

}
