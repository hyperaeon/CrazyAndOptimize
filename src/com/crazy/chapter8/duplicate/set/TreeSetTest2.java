package com.crazy.chapter8.duplicate.set;

import java.util.TreeSet;

class Z implements Comparable {
	int age;

	public Z(int age) {
		this.age = age;
	}

	public boolean equals(Object obj) {
		return true;
	}

	public int compareTo(Object obj) {
		return 1;
	}
}

public class TreeSetTest2 {

	public static void main(String[] args) {
		TreeSet<Z> set = new TreeSet<>();
		Z z1 = new Z(6);
		set.add(z1);
		System.out.println(set.add(z1));
		System.out.println(set);

		set.first().age = 9;
		System.out.println(set.last().age);
	}
}
