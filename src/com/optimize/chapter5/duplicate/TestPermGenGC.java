package com.optimize.chapter5.duplicate;

public class TestPermGenGC {

	public static void main(String[] args) {
		permGenGC();
	}
	
	public static void permGenGC() {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			String t = String.valueOf(i).intern();
		}
	}
}
