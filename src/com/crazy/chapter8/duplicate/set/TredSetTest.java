package com.crazy.chapter8.duplicate.set;

import java.util.TreeSet;

public class TredSetTest {

	public static void main(String[] args) {
		TreeSet<Integer> nums = new TreeSet<>();
		nums.add(5);
		nums.add(2);
		nums.add(10);
		nums.add(-9);
		System.out.println(nums);
		System.out.println(nums.first());
		System.out.println(nums.last());
		System.out.println(nums.headSet(4));
		System.out.println(nums.tailSet(5));
		System.out.println(nums.subSet(-3, 4));
		
	}
}
