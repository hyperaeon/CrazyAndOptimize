package com.optimize.chapter3.duplicate;

import java.util.Vector;

public class CollectionOptimize {

	public static void main(String[] args) {
		Vector<String> v = new Vector<>();
		v.add("north63");
		v.add("west63");
		v.add("east63");
		v.add("east32");
		v.add("west3");
		v.add("south633");
		v.add("east63");
		long start = System.nanoTime();
		int count = 0;
		for (int i = 0; i < v.size(); i ++) {
			if (v.get(i).indexOf("north") != -1
					|| v.get(i).indexOf("south") != -1
					|| v.get(i).indexOf("sourth") != -1) {
				count ++;
			}
		}
		System.out.println("First spend : " + (System.nanoTime() - start));
		
		start = System.nanoTime();
		count = 0;
		int size = v.size();
		for (int i = 0; i < size; i ++) {
			if (v.get(i).indexOf("north") != -1
					|| v.get(i).indexOf("south") != -1
					|| v.get(i).indexOf("sourth") != -1) {
				count ++;
			}
		}
		System.out.println("Second spend : " + (System.nanoTime() - start));
		
		start = System.nanoTime();
		count = 0;
		size = v.size();
		String s = null;
		for (int i = 0; i < v.size(); i ++) {
			if ((s = v.get(i)).indexOf("north") != -1
					|| s.indexOf("south") != -1
					|| s.indexOf("sourth") != -1) {
				count ++;
			}
		}
		System.out.println("Third spend : " + (System.nanoTime() - start));
	}
}
