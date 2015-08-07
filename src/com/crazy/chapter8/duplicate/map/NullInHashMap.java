package com.crazy.chapter8.duplicate.map;

import java.util.HashMap;
import java.util.Map;

public class NullInHashMap {

	public static void main(String[] args) {
		Map<String, String> hm = new HashMap<>();
		hm.put(null, null);
		hm.put(null, null);
		hm.put("a", null);
		System.out.println(hm);

	}
}
