package com.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		Map<String, String> m = new LinkedHashMap<>();
		m.put("a", "aa");
		m.put("d", "dd");
		m.put("c", "cc");
		m.put("b", "bb");
		Iterator<String> key = m.keySet().iterator();
		while (key.hasNext()) {
			System.out.println(m.get(key.next()));
		}
	}
}
