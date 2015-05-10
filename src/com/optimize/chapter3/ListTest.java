package com.optimize.chapter3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ListTest {

	public static void main(String[] args) {
		List<Object> aryList = new ArrayList<>();
		long start = System.currentTimeMillis();
		Object obj = new Object();
		for (int i = 0; i < 50000; i++) {
			aryList.add(0, obj);
		}
		System.out.println("ArrayList waste : " + (System.currentTimeMillis() - start));
		List<Object> linkList = new LinkedList<>();
		start = System.currentTimeMillis();
		obj = new Object();
		for (int i = 0; i < 50000; i++) {
			linkList.add(0, obj);
		}
		System.out.println("LinkedList waste : " + (System.currentTimeMillis() - start));
	}
}
