package com.crazy.chapter8;

import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args){
		TreeSet<Integer> nums = new TreeSet<>();
		nums.add(0);
		nums.add(-3);
		nums.add(9);
		nums.add(5);
		System.out.println(nums);
		System.out.println(nums.first());
		System.out.println(nums.last());
		System.out.println(nums.subSet(0, 5));
		System.out.println(nums.headSet(5));
		System.out.println(nums.tailSet(0));
		
	}
}
