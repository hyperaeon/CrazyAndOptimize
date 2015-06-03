package com.test;

public class NullEqualsTest {

	public static void main(String[] args) {
//		String str = null;
//		System.out.println(str.equals(null));
		StringBuffer buffer = new StringBuffer();
		buffer.append("abc"     );
		StringBuffer buffer2 = new StringBuffer();
		buffer2.append("abc" );
		System.out.println(buffer.toString());
		
	}
}
