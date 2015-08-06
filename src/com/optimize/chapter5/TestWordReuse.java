package com.optimize.chapter5;

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

	public static void test3() {
		{
			byte[] b = new byte[6 * 1024 * 1024];
		}
		System.gc();
		System.out.println("first explict gc over");
	}

	public static void test4() {
		{
			int c = 0;
			byte[] b = new byte[6 * 1024 * 1024];
		}
		int a = 0;
		System.gc();
		System.out.println("first explict gc over");
	}

	public static void test5() {
		{
			int c = 0;
			byte[] b = new byte[6 * 1024 * 1024];
		}
		int a = 0;
		int d = 0;
		System.gc();
		System.out.println("first explict gc over");
	}

	public static void main(String[] args) {
		test3();
	}
}
