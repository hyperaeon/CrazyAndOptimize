package com.crazy.chapter8.duplicate;

import java.util.ArrayList;
import java.util.Collections;

public class SortTest {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(2);
		nums.add(-5);
		nums.add(3);
		nums.add(0);
		System.out.println(nums);

		Collections.reverse(nums);
		System.out.println(nums);
		Collections.sort(nums);
		System.out.println(nums);
		Collections.shuffle(nums);
		System.out.println(nums);
	}
}
