package com.crazy.chapter9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pear<T extends Number> {

	T col;
	public static void main(String[] args){
		Pear<Integer> p1 = new Pear<>();
		Pear<Double> p2 = new Pear<>();
		String[] strArr = {"a","b"};
		List<String> strList = new ArrayList<>();
		fromArrayToCollection(strArr, strList);
	}
	
	public static <T> void fromArrayToCollection(T[] a,Collection<T> c){
		for(T o : a){
			c.add(o);
		}
	}
}
