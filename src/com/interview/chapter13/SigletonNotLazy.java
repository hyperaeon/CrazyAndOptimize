package com.interview.chapter13;

public class SigletonNotLazy {

	private static SigletonNotLazy instance = new SigletonNotLazy();

	private SigletonNotLazy() {

	}

	public SigletonNotLazy getInstance() {
		return instance;
	}
	
	public static void main(String[] args) {
		SigletonNotLazy l = new SigletonNotLazy();
		System.out.println(l.getInstance());
		
		SigletonNotLazy l2 = new SigletonNotLazy();
		System.out.println(l.getInstance() == l2.getInstance());
	}
}
