package com.crazy.chapter10;

public class FinallyFlowTest {

	public static void main(String[] args) throws Exception {
		boolean a = test();
		System.out.println(a);
	}

	public static boolean test() {
		try {
			throw new Exception("abc");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
		}
		return true;
	}
}
