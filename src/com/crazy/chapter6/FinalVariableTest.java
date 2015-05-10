package com.crazy.chapter6;

public class FinalVariableTest {

	final int a = 6;
	final String str;
	final int c;
	final static double d;
	
	final char ch;
	
	{
		str = "Hello";
	}
	static {
		d = 5.6;
	}
	
	public FinalVariableTest() {
		c = 5;
		ch = '3';
	}
	
	public void test(final int f) {
	}
}
