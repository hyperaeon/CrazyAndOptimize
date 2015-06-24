package com.crazy.chapter8.duplicate.map;

import java.util.Hashtable;

class A {
	int count;

	public A(int count) {
		this.count = count;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && obj.getClass() == A.class) {
			A a = (A) obj;
			return a.count == this.count;
		}
		return false;
	}

	public int hashCode() {
		return this.count;
	}
}

class B {
	public boolean equals(Object obj) {
		return true;
	}
}

public class HashtableTest {

	public static void main(String[] args) {
		Hashtable<A, Object> ht = new Hashtable<A, Object>();
		ht.put(new A(60000), "java1");
		ht.put(new A(87654), "java2");
		ht.put(new A(1232), new B());
		System.out.println(ht);
		System.out.println(ht.containsValue("deshi"));
		
		System.out.println(ht.containsKey(new A(87654)));
		ht.remove(new A(1232));
		
		for (Object key : ht.keySet()) {
			System.out.print(key + "---->");
			System.out.print(ht.get(key) + "\n");
		}
	}
}
