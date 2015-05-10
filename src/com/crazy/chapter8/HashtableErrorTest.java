package com.crazy.chapter8;

import java.util.Hashtable;
import java.util.Iterator;

public class HashtableErrorTest {

	public static void main(String[] args){
		Hashtable ht = new Hashtable<>();
		ht.put(new E(3000), "java1");
		ht.put(new E(6000), "java2");
		Iterator it = ht.keySet().iterator();
		E first = (E)it.next();
		first.count = 6000;
		System.out.println(ht);
		ht.remove(new E(6000));
		System.out.println(ht);
		System.out.println(ht.get(new E(3000)));
		System.out.println(ht.get(new E(6000)));
		
	}
}
