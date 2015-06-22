package com.optimize.chapter5;

import org.junit.Test;

public class MethodAreaTest {

	@Test
	public void permGenGC() {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			String t = String.valueOf(i).intern();
//			System.out.println(t.hashCode());
		}
	}
	
	public static void main(String[] args) {
		new MethodAreaTest().permGenGC();
	}
}
