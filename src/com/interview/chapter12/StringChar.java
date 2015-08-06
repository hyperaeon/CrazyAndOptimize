package com.interview.chapter12;

public class StringChar {

	public static void main(String[] args) {
		String s = "10";
		char c[] = {'h','e','l','l','o'};
		Integer i = 10;
		if (s.equals(c)) {
			System.out.println("c equals s");
		}
		if (s.equals(i)) {
			System.out.println("s equals i");
		}
	}
}
