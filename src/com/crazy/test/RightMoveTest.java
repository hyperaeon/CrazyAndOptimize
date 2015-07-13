package com.crazy.test;

public class RightMoveTest {

	public static void main(String[] args) {
		int cap = 2;
		int newCap = cap + (cap >> 1) + 1;
		System.out.println(newCap);
		
		System.out.println("2 >> 1:" + (cap >> 1));
		System.out.println("2 >> 2:" + (cap >> 2));
		System.out.println("2 >> 2:" + (cap >>> 3));
	}
}
