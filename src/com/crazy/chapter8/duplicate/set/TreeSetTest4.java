package com.crazy.chapter8.duplicate.set;

import java.util.Comparator;
import java.util.TreeSet;

class M {
	int age;

	public M(int age) {
		this.age = age;
	}

	public String toString() {
		return "M[age:" + age + "]";
	}
}

public class TreeSetTest4 {

	public static void main(String[] args) {
		TreeSet<M> ts = new TreeSet<M>(new Comparator<M>() {

			@Override
			public int compare(M o1, M o2) {
				return o1.age > o2.age ? -1 : o1.age < o2.age ? 1 : 0;
			}
		});
		ts.add(new M(5));
		ts.add(new M(-3));
		ts.add(new M(9));
		System.out.println(ts);
	}
}
