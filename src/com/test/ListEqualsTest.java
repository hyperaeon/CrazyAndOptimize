package com.test;

import java.util.ArrayList;
import java.util.List;

public class ListEqualsTest {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<String>();
		list1.add("abc");
		list1.add("bcd");
		list2.add("bcd");
		list2.add("abc");
		System.out.println(list1.equals(list2));
	}
}
