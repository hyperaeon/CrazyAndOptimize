package com.optimize.chapter3;

import java.util.Collection;
import java.util.Vector;

public class CollectionOptimize {

	public static void main(String[] args) {
		Vector<String> collection = new Vector<>();
		collection.add("north65");
		collection.add("west20");
		collection.add("east30");
		collection.add("sourth40");
		collection.add("west33");
		collection.add("sourth20");
		collection.add("north10");
		collection.add("east9");
		int count = 0;
		String s = null;
		for (int i = 0; i < collection.size(); i++) {
			if ((s = (String) collection.get(i)).indexOf("north") != -1
				|| s.indexOf("west") != -1
				|| s.indexOf("sourth") != -1) {
					count++;
				}
		}
		int colsize = collection.size();
		for (int i = 0; i < colsize; i++) {
			if ((s = (String) collection.get(i)).indexOf("north") != -1
				|| s.indexOf("west") != -1
				|| s.indexOf("sourth") != -1) {
					count++;
				}
		}
		System.out.println(count);
	}
}
