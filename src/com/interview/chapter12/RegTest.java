package com.interview.chapter12;

public class RegTest {

	public static void main(String[] args) {
		String str = "2006-04-02 02:22:02";
		String str2 = "";
		String[] result = str.split("\\D");
		for (int i = 0; i < result.length; i++) {
			str2 += result[i];
		}
		System.out.println(str2);

	}
}
