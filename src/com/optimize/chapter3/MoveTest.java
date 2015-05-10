package com.optimize.chapter3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MoveTest {

	public static void main(String[] args) {
		int a = 5;
		System.out.println(a << 1);
		List<String> list = new ArrayList<>(100000);
		long start = System.currentTimeMillis();
		for (Integer i = 0; i < list.size(); i ++) {
			list.add(i.toString());
		}
		System.out.println("for add : " + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		for (int i = 0; i < list.size(); i ++) {
			list.get(i);
		}
		System.out.println("for each : " + (System.currentTimeMillis() - start));
		
	}
}
