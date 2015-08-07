package com.crazy.chapter8.duplicate.map;

import java.util.Hashtable;
import java.util.Iterator;

public class HashtableErrorTest {

	public static void main(String[] args) {
		Hashtable<A, String> ht = new Hashtable<>();
		ht.put(new A(60000), "java1");
		ht.put(new A(87654), "java2");
		Iterator<A> it = ht.keySet().iterator();
		A first = it.next();
		first.count = 87654;
		System.out.println(ht);

		ht.remove(new A(87654));
		System.out.println(ht);

		System.out.println(ht.get(new A(87654)));
		System.out.println(ht.get(new A(60000)));
	}
}
