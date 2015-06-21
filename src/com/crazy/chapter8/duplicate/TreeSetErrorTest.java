package com.crazy.chapter8.duplicate;

import java.util.TreeSet;

class Err {

}

public class TreeSetErrorTest {

	public static void main(String[] args) {
		TreeSet<Err> ts = new TreeSet<>();
		ts.add(new Err());
		ts.add(new Err());

	}

}
