package com.crazy.chapter8;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args){
		Set books = new HashSet<>();
		books.add(new String("java1"));
		boolean result = books.add(new String("java1"));
		System.out.println(result);
	}
}
