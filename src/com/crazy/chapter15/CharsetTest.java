package com.crazy.chapter15;

import java.nio.charset.Charset;
import java.util.SortedMap;

public class CharsetTest {

	public static void main(String[] args) {
		SortedMap<String, Charset> charset = Charset.availableCharsets();
		for (String key : charset.keySet()) {
			System.out.println(key + ": " + charset.get(key));
		}
	}
}
