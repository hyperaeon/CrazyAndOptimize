package com.crazy.chapter9;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args){
		TreeSet<String> ts1 = new TreeSet<>(new Comparator<Object>() {
			public int compare(Object fst,Object snd){
				return fst.hashCode() > snd.hashCode() ? 1 :
					fst.hashCode() < snd.hashCode() ? -1 : 0;
			}
		});
		ts1.add("hello");
		ts1.add("sd");
		System.out.println(ts1);
		TreeSet<String> ts2 = new TreeSet<>(new Comparator<String>(){
			public int compare(String fst,String snd){
				return fst.length() > snd.length() ? -1 :
					fst.length() < snd.length() ? 1 : 0;
			}
		});
		ts2.add("hello");
		ts2.add("we");
		System.out.println(ts2);
	}
}
