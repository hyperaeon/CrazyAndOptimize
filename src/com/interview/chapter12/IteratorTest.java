package com.interview.chapter12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Welcome ");
		list.add("to ");
		list.add("Xian ");
		for(Iterator<String> i = list.iterator(); i.hasNext(); ) {
			String s = i.next();
			System.out.println(s);
		}
	}
}

