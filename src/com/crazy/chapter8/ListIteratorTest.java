package com.crazy.chapter8;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {
 
	public static void main(String[] args){
		String[] books = {
				"java1","java2"
		};
		List bookList = new ArrayList<>();
		for(String book : books){
			bookList.add(book);
		}
		ListIterator lit = bookList.listIterator();
		while(lit.hasNext()){
			System.out.println(lit.next());
			lit.add("-----�����ķָ���-------");
		}
		System.out.println("-----�������-------");
		while(lit.hasPrevious()){
			System.out.println(lit.previous());
		}
	}
}
