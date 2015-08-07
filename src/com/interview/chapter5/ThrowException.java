package com.interview.chapter5;

public class ThrowException {

	public void divide() throws Exception {
		try {
			int i = 3;
			int j = 0;
			int a = i / j ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("error");
		}
		System.out.println("after try catch");
	}

	public static void main(String[] args)  throws Exception {
		new ThrowException().divide();
	}
}
