package com.crazy.chapter8.duplicate.set;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;

public class EnumSetTest2 {

	public static void main(String[] args) {
		Collection c = new HashSet<>();
		c.clear();
		c.add(Season.FALL);
		c.add(Season.SPRING);
		EnumSet set = EnumSet.copyOf(c);
		System.out.println(set);

		c.add("∑‹∂∑");
		c.add("«Â¡π");
		set = EnumSet.copyOf(c);
	}
}
