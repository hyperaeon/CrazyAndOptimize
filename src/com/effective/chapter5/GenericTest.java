package com.effective.chapter5;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
		unsafe(strings, new Integer(24));
		String s = strings.get(0);
	}
	
	public static void unsafe(List list, Object o) {
		list.add(o);
	}
}
