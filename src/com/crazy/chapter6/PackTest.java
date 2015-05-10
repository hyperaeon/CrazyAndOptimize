package com.crazy.chapter6;

public class PackTest {

	static final Integer[] cache = new Integer[-(-128) + 127 + 1];
	
	static{
		for(int i = 0; i < cache.length; i ++){
			cache[i] = new Integer(i - 128);
		}
	}
	public static void main(String[] args){
		Integer inta = 128;
		Integer intb = 128;
		System.out.println(inta == intb);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Boolean.compare(true, false));
	}
}
