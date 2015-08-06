package com.interview.chapter12;

public class StringBufferTest {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 50000; i++) {
			buffer.append("hello");
		}
		System.out.println("Spend: " + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		StringBuffer buffer2 = new StringBuffer(250000);
		for (int i = 0; i < 50000; i++) {
			buffer2.append("hello");
		}
		System.out.println("Spend: " + (System.currentTimeMillis() - start));
	}
}
