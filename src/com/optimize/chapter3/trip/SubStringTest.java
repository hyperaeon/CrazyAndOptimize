package com.optimize.chapter3.trip;

import java.util.ArrayList;
import java.util.List;

public class SubStringTest {

	public static void main(String[] args) {
		List<String> handler = new ArrayList<String>();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			HugeStr h = new HugeStr();
			handler.add(h.getSubString(1, 5));
		}
		System.out.println("HugeStr waste: "
				+ (System.currentTimeMillis() - start));
		handler.clear();
		start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			ImprovedHugeStr h = new ImprovedHugeStr();
			handler.add(h.getSubString(1, 5));
		}
		System.out.println("ImprovedHugeStr waste: "
				+ (System.currentTimeMillis() - start));
	}

	static class HugeStr {
		private String str = new String(new char[100000]);

		public String getSubString(int begin, int end) {
			return str.substring(begin, end);
		}
	}

	static class ImprovedHugeStr {
		private String str = new String(new char[100000]);

		public String getSubString(int begin, int end) {
			return new String(str.substring(begin, end));
		}
	}
}
