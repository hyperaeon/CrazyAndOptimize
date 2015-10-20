package com.effective.chapter7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetList {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			set.add(i);
			list.add(i);
		}

		for (int i = 0; i < 10; i++) {
			set.remove(i);
			list.remove(Integer.valueOf(i));
		}
		System.out.println(set + " " + list);
	}
}
