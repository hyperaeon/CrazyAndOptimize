package com.crazy.chapter8;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;

public class EnumSetTest2 {

	public static void main(String[] args){
		Collection c = new HashSet();
		c.clear();
		c.add(Season.FALL);
		c.add(Season.SPRING);
		EnumSet enumSet = EnumSet.copyOf(c);
		System.out.println(enumSet);
		c.add("java1");
		c.add("java2");
		enumSet = EnumSet.copyOf(c);
	}
}
