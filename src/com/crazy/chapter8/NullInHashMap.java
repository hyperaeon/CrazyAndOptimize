package com.crazy.chapter8;

import java.util.HashMap;

public class NullInHashMap {

	public static void main(String[] args){
		HashMap hs = new HashMap<>();
		hs.put(null, null);
		hs.put(null, null);
		hs.put("a", null);
		hs.put("b","abc");
		hs.put("b", "dbd");
		System.out.println(hs);
	}
}
