package com.interview.chapter5;

public class CharTest {

	public static void main(String[] args) {
		char ch[] = {'H', 'e', 'l', 'l', 'o'};
		change(ch);
		System.out.println(ch);
	}

	private static void change(char[] ch) {
		ch[0] = 'C';
	}
	
	
}
