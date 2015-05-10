package com.crazy.chapter9;

import java.util.ArrayList;
import java.util.List;

public class U<T> {

	public static void test(List<? extends Object> c){
		System.out.println(c.get(0));
	}
	public static void main(String[] args){
		List<String> list = new ArrayList<>();
		list.add("jsdf");
		test(list);
		
	}
}
