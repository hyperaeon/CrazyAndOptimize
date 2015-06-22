package com.interview.chapter5;

public class Sandys {

	private int court;

	public static void main(String[] args) {
		Sandys s = new Sandys(99);
		System.out.println(s.court);
	}

	Sandys(int ballcount) {
		court = ballcount;
	}
}
