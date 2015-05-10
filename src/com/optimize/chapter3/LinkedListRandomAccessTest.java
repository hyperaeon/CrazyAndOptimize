package com.optimize.chapter3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListRandomAccessTest {

	public static void main(String[] args) {
//		List<Integer> list = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			list.add(i);
		}
		System.out.println("add waste : " + (System.currentTimeMillis() - start) + "ms");
		start = System.currentTimeMillis();
		for (int k = 0; k < 100; k++) {
			for (int i = 0; i < 10000; i ++) {
				list.get(i);
			}
		}
		System.out.println("get waste : " + (System.currentTimeMillis() - start) + "ms");
	}
}
