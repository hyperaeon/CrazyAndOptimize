package com.crazy.chapter8.duplicate.set;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		Set<String> books = new HashSet<>();
		books.add(new String("·è¿ñjava½²Òå"));
		boolean result = books.add(new String("·è¿ñjava½²Òå"));
		System.out.println(result + "--->" + books);
	}
}
