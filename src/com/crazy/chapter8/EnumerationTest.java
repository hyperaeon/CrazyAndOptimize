package com.crazy.chapter8;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

public class EnumerationTest {

	public static void main(String[] args){
		Vector v = new Vector<>();
		v.add("java1");
		v.add("java2");
		Hashtable scores = new Hashtable<>();
		scores.put("java3",90);
		scores.put("java4", 89);
		Enumeration em = v.elements();
		while(em.hasMoreElements()){
			System.out.println(em.nextElement());
		}
		em = scores.keys();
		while(em.hasMoreElements()){
			Object key = em.nextElement();
			System.out.println(key + "---> " +
					scores.get(key));
		}
		HashMap books = new HashMap<>();
		books.put("java3",90);
		books.put("java4", 89);
	}
}
