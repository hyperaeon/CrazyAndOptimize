package com.interview.chapter5;

public class ExceptionTest3 {

	public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void test() throws Exception {
		throw new Exception("test");
	}
}
