package com.interview.chapter5;

import com.crazy.chapter14.Person;

public class FinalTest {

	public static void finalParam(final String p) {
		System.out.println(p.hashCode());
//		p = "as";
//		System.out.println(p.hashCode());
		// p = new Person();
		try {
			test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void test() throws Exception {

	}
	
	public static void main(String[] args) {
		finalParam("bbb");
	}
}
