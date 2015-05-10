package com.optimize.chapter3;

import java.util.ArrayList;
import java.util.List;

public class SubString {

	public static void main(String[] args) {
		List<String> handler = new ArrayList<String>();
		for (int i = 0; i < 10000; i++) {
			HugeStr h = new HugeStr();
			ImprovedHugeStr ih = new ImprovedHugeStr();
			handler.add(h.getSubString(0, 10000));
		}
	}

	static class HugeStr {
		private String str = new String(new char[1000000]);

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
