package com.optimize.chapter3.duplicate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListAddTest {

	public static void main(String[] args) {
		ListAddTest lat = new ListAddTest();
		long start = System.currentTimeMillis();
		lat.arrayListTest();
		System.out.println("arrayListTest() waste time: "
				+ (System.currentTimeMillis() - start) + " ms");
		
		start = System.currentTimeMillis();
		lat.linkedListTest();
		System.out.println("linkedListTest() waste time: "
				+ (System.currentTimeMillis() - start) + " ms");
		
	}
	
	public void arrayListTest() {
		List<Object> list = new ArrayList<>();
		Object obj = new Object();
		for (int i = 0; i < 500000; i++) {
			list.add(0, obj);
		}
	}
	
	public void linkedListTest() {
		List<Object> list = new LinkedList<>();
		Object obj = new Object();
		for (int i = 0; i < 500000; i++) {
			list.add(0, obj);
		}
	}
}
