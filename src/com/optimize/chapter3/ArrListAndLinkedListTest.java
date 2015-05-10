package com.optimize.chapter3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrListAndLinkedListTest {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 500000; i ++) {
			list1.add(i);
		}
		System.out.println("ArrayList waste : " + (System.currentTimeMillis() - start));
		
		List<Integer> list2 = new LinkedList<>();
		start = System.currentTimeMillis();
		for (int i = 0; i < 500000; i ++) {
			list2.add(i);
		}
		System.out.println("LinkedList waste : " + (System.currentTimeMillis() - start));
		
		
	}
}
