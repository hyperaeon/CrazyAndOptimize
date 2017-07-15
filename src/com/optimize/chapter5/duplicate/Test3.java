package com.optimize.chapter5.duplicate;

public class Test3 {

	public static void main(String[] args) {
		test1();
		System.gc();
		System.out.println("main explict gc over");
		test2();
//		{
//			byte[] b = new byte[6 * 1024 * 1024];
//		}
//		int a = 0;
//		System.gc();
//		System.out.println("First explict gc over");
	}
	
	public static void test1() {
		{
			byte[] b = new byte[6 * 1024 * 1024];
		}
		System.gc();
		System.out.println("First explict gc over");
	}
	
	public static void test2() {
		{
			byte[] b = new byte[6 * 1024 * 1024];
		}
		int a = 0;
		System.gc();
		System.out.println("Second explict gc over");
	}
	
}
