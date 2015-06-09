package com.optimize.chapter3.duplicate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListRemoveTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
//		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < 50000; i++) {
			list.add(i);
		}
		long start = System.currentTimeMillis();
		while(list.size() > 0) {
			list.remove(0);
		}
		System.out.println("head waste: " + (System.currentTimeMillis() - start) + "ms");
		for (int i = 0; i < 50000; i++) {
			list.add(i);
		}
		start = System.currentTimeMillis();
		while(list.size() > 0) {
			list.remove(list.size() >> 1);
		}
		System.out.println("middle waste: " + (System.currentTimeMillis() - start) + "ms");
		for (int i = 0; i < 50000; i++) {
			list.add(i);
		}
		start = System.currentTimeMillis();
		while(list.size() > 0) {
			list.remove(list.size() - 1);
		}
		System.out.println("tail waste: " + (System.currentTimeMillis() - start) + "ms");
	}
}
