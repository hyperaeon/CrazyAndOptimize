package com.crazy.chapter8.duplicate.map;

import java.util.WeakHashMap;

public class WeakHashMapTest {

	public static void main(String[] args) {
		WeakHashMap<String, String> whm = new WeakHashMap<>();
		whm.put(new String("chinese"), new String("good"));
		whm.put(new String("math"), new String("middle"));
		whm.put(new String("english"), new String("perfect"));
		whm.put("java", "great");
		System.out.println(whm);
		System.gc();
		System.runFinalization();
		System.out.println(whm);
	}
}
