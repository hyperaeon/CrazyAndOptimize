package com.optimize.chapter3.duplicate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IterationTest {

	public static void main(String[] args) {
		String tmp;
//		List<String> list = new ArrayList<>();
		List<String> list = new LinkedList<>();
		for (int i = 0; i < 1000000; i++) {
			list.add(i + "");
		}
		long start = System.currentTimeMillis();
		for (String s : list) {
			tmp = s;
		}
		System.out.println("foreach spend: " + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		for (Iterator<String> it = list.iterator(); it.hasNext();) {
			tmp = it.next();
		}
		System.out.println("Iterator spend: " + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		int size = list.size();
		for (int i = 0; i < size; i++) {
			tmp = list.get(i);
		}
		System.out.println("for spend: " + (System.currentTimeMillis() - start));
	}
}
