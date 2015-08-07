package com.interview.chapter12;

import java.util.HashMap;
import java.util.Map;

public class DominateStatistic {

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 4, 3, 2, 3, 1, 2 };
		long start = System.nanoTime();
		System.out.println(dom(arr));
		System.out.println("Spend: " + (System.nanoTime() - start));
		System.out.println(arr.length >> 1);
	}

	public static int dom(int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.get(arr[i]) != null) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > arr.length >> 1) {
				return entry.getKey();
			}
		}
		return -1;
	}
}
