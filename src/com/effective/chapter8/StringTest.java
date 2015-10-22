package com.effective.chapter8;

public class StringTest {

	public String statements() {
		String result = "";
		for (int i = 0; i < numItems(); i++) {
			result += lineForItem(i);
		}
		return result;
	}

	private int numItems() {
		return 1000000;
	}

	private String lineForItem(int i) {
		return i + "";
	}

	public static void main(String[] args) {
		System.out.println(new StringTest().statements());
	}
}
