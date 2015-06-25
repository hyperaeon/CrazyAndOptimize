package com.optimize.chapter3.duplicate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;

public class RandomAccessTest {

	public static void main(String[] args) {
//		List<String> list = new ArrayList<>();
		List<String> list = new LinkedList<>();
		list.add("abc");
		String str = null;
		if (list instanceof RandomAccess) {
			for (int i = 0; i < list.size(); i++) {
				str = list.get(i);
				System.out.println("array : " + str);
			}
		} else {
			Iterator<String> it = list.iterator();
			for (int i = 0, n = list.size(); i < n; i++) {
				str = it.next();
				System.out.println("Iterator : " + str);
			}
		}
		
	}
}
