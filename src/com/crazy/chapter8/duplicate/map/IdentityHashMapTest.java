package com.crazy.chapter8.duplicate.map;

import java.util.IdentityHashMap;

public class IdentityHashMapTest {

	public static void main(String[] args) {
		IdentityHashMap<String, Integer> ihm = new IdentityHashMap<>();
		ihm.put(new String("chinese"), 99);
		ihm.put(new String("chinese"), 98);
		ihm.put("java", 88);
		ihm.put("java", 89);
		System.out.println(ihm);
	}
}
