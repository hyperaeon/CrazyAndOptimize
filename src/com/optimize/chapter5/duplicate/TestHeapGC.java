package com.optimize.chapter5.duplicate;

public class TestHeapGC {

	public static void main(String[] args) {
		testHeapGC();
	}
	
	
	
	public static void testHeapGC() {
		byte[] b1 = new byte[1024 * 1024 / 2];
		byte[] b2 = new byte[1024 * 1024 * 8];
		b2 = null;
		b2 = new byte[1024 * 1024 * 8];
	}
}
