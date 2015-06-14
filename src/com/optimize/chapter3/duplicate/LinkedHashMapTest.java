package com.optimize.chapter3.duplicate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LinkedHashMapTest {

	public static void main(String[] args) {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("1", "aa");
		map.put("2", "bb");
		map.put("3", "cc");
		map.put("4", "dd");
		map.get("3");
		for (Iterator<String> iterator = map.keySet().iterator(); iterator
				.hasNext();) {
			String name = iterator.next();
			System.out.println(name + "->" + map.get(name));
		}
		List<String> list = new ArrayList<>();
		list.add("abc");
		list.add("bcd");
		list.add("cde");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().endsWith("abc")) {
				iterator.remove();
			}
		}
		System.out.println(list);
//		for (String str : list) {
//			if (str.equals("abc")) {
//				list.remove(0);
//			}
//		}
	}
}
