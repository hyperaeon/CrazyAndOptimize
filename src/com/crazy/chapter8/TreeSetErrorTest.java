package com.crazy.chapter8;

import java.util.TreeSet;

class Err implements Comparable<Err>{

	int count ;
	@Override
	public int compareTo(Err o) {
		
		return this.count - o.count;
	}
	
}
public class TreeSetErrorTest {

	public static void main(String[] args){
		TreeSet<Err> ts = new TreeSet<>();
		ts.add(new Err());
		ts.add(new Err());
		
	}
}
