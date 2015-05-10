package com.crazy.chapter8;

import java.util.ArrayList;
import java.util.List;

class D{
	public boolean equals(Object obj){
		return true;
	}
}
public class ListTest2 {

	public static void main(String[] args){
		List<String> books = new ArrayList<String>();
		books.add("java1");
		books.add("java2");
		books.add("java3");
		System.out.println(books);
		books.remove(new D());
		System.out.println(books);
		books.remove(new D());
		System.out.println(books);
		books.set(0, "java4");
		System.out.println(books);
	}
}
