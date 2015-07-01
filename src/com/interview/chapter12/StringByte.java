package com.interview.chapter12;

import java.io.UnsupportedEncodingException;

public class StringByte {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "Œ“abc";
		String s = new String(str.getBytes(), "GBK");
		System.out.println(s.getBytes("GBK").length);
	}
}
