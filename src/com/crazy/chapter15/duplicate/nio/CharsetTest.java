package com.crazy.chapter15.duplicate.nio;

import java.nio.charset.Charset;
import java.util.SortedMap;

public class CharsetTest {

	public static void main(String[] args) {
		SortedMap<String, Charset> map = Charset.availableCharsets();
		for (String alias : map.keySet()) {
			System.out.println(alias + "----->" + map.get(alias));
		}
	}
}
