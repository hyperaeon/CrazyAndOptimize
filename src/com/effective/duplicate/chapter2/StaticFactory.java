package com.effective.duplicate.chapter2;

public class StaticFactory {

	public static void main(String[] args) {
		Boolean b1 = Boolean.valueOf("true");
		Boolean b2 = Boolean.valueOf("true");
		System.out.println(b1 == b2);
	}
}
