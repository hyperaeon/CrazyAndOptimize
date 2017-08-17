package com.crazy.chapter15.fourth.charset;

import java.nio.charset.Charset;
import java.util.SortedMap;

public class CharsetTest {

	public static void main(String[] args) {
		SortedMap<String, Charset> map = Charset.availableCharsets();
		map.keySet().forEach(key -> System.out.println(key));
	}
}
