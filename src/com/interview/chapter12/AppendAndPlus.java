package com.interview.chapter12;

public class AppendAndPlus {

	private static long start;
	public static void main(String[] args) {
		start = System.nanoTime();
		StringBuffer b = new StringBuffer();
		b.append("s1").append("s2").append("s3");
		System.out.println("Spend: " + (System.nanoTime() - start));
		
		start = System.nanoTime();
		String s = "s1";
		s += "s2";
		s += "s3";
		System.out.println("Spend: " + (System.nanoTime() - start));


	}
}
