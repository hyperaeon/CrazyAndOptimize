package com.crazy.chapter8;

import java.util.IdentityHashMap;

public class IdentityHashMapTest {

	public static void main(String[] args){
		IdentityHashMap ihm = new IdentityHashMap<>();
		ihm.put("java",90);
		ihm.put("java",30);
		ihm.put(new String("java1"),340);
		ihm.put(new String("java2"),80);
		System.out.println(ihm);
	}
}
