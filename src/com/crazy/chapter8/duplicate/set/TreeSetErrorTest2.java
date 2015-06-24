package com.crazy.chapter8.duplicate.set;

import java.util.Date;
import java.util.TreeSet;

public class TreeSetErrorTest2 {

	public static void main(String[] args) {
		TreeSet<Object> tr = new TreeSet<>();
		tr.add(new String("testr"));
		tr.add(new Date());
	}
}
