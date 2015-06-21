package com.interview.chapter5;

public class UnicodeTest {

	public static void main(String[] args) {
		char han = 'บบ';
		System.out.format("%x", (short) han).println();
		char hanCh = 0x6c49;
		System.out.println(hanCh);
		int k = (int) 056L;
		System.out.println(k);
	}
}
