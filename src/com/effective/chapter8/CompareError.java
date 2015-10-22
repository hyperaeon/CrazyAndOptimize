package com.effective.chapter8;

import java.util.Comparator;

public class CompareError {

	public static void main(String[] args) {
		Comparator<Integer> naturalOrder = new Comparator<Integer>() {
			public int compare(Integer first, Integer second) {
				return first < second ? -1 : (first == second ? 0 : 1);
			}
		};
		System.out.println(naturalOrder.compare(new Integer(42),
				new Integer(42)));

	}
}
