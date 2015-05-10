package com.crazy.chapter6;

public class NullAccessStatic {

	public static void test(){
		System.out.println("test");
	}
	
	public static void main(String[] args){
		NullAccessStatic na = null;
		na.test();
	}
}

