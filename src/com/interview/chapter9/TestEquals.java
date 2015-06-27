package com.interview.chapter9;

import java.util.ArrayList;
import java.util.List;

public class TestEquals {

	private String value = null;
	
	public TestEquals(String v) {
		this.value = v;
	}
	
	public boolean equals(TestEquals t ) {
		if (t == this) {
			return true;
		}
		if (t instanceof TestEquals) {
			TestEquals test = (TestEquals) t;
			return value.equals(test.value);
		}
		return false;
	}
	
	public static void main(String[] args) {
		List<TestEquals> list = new ArrayList<>();
		TestEquals test1 = new TestEquals("object");
		TestEquals test2 = new TestEquals("object");
		TestEquals test3 = new TestEquals("object");
		Object test4 = new TestEquals("object");
		list.add(test1);
		System.out.println(list.contains(test2));
		System.out.println(test2.equals(test3));
		System.out.println(test3.equals(test4));
	}
}
