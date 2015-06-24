package com.crazy.chapter8.duplicate.list;

import java.util.Arrays;
import java.util.List;

public class FixedSizeList {

	public static void main(String[] args) {
		List<String> fixedList = Arrays.asList("java1","java2");
		System.out.println(fixedList.getClass());
		for (int i = 0; i < fixedList.size(); i++) {
			System.out.println(fixedList.get(i));
		}
		fixedList.add("java3");
		fixedList.add("java2");
	}
}
