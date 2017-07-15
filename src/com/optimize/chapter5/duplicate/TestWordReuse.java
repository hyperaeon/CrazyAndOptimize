package com.optimize.chapter5.duplicate;

public class TestWordReuse {

	public void test1() {
		{
			long a = 0;
		}
		long b = 0;
	}
	
	public void test2() {
		long a = 0;
		long b = 0;
	}
}
