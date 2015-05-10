package com.optimize.chapter3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapTest {

	public static void main(String[] args) {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("1", "aa");
		map.put("2", "bb");
		map.put("3", "cc");
		map.put("4", "dd");
		map.get("3");
		for (Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext();) {
			String name = iterator.next();
			System.out.println(name + "->" + map.get(name));
		}
		map = new HashMap<>();
		map.put("1", "aa");
		map.put("2", "bb");
		map.put("3", "cc");
		map.put("4", "dd");
		map.get("3");
		for (Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext();) {
			String name = iterator.next();
			System.out.println(name + "->" + map.get(name));
		}
		
		map = new LinkedHashMap<String, String>(16, 0.75f, true);
		map.put("1", "aa");
		map.put("2", "bb");
		map.put("3", "cc");
		map.put("4", "dd");
		map.get("3");
		for (Integer i = 1; i <= map.size(); i ++) {
			System.out.println("->" + map.get(i.toString()));
		}
		
	}
}
