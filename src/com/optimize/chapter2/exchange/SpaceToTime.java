package com.optimize.chapter2.exchange;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SpaceToTime {

	private static final int arrLen = 1000000;
	
	public static void main(String[] args) {
		int[] a = new int[arrLen];
		int[] old = new int[arrLen];
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		int count = 0;
		while (count < a.length) {
			int value = (int) (Math.random() * arrLen * 10) + 1;
			if (map.get(value) == null) {
				map.put(value, value);
				a[count] = value;
				count ++;
			}
		}
		System.arraycopy(a, 0, old, 0, arrLen);
		long start = System.currentTimeMillis();
		Arrays.sort(a);
		System.out.println("Arrays.sort spend: " + (System.currentTimeMillis() - start) + "ms");
		System.arraycopy(old, 0, a, 0, arrLen);
		start = System.currentTimeMillis();
		spaceToTime(a);
		System.out.println("spaceToTime spend: " + (System.currentTimeMillis() - start) + "ms");
	}
	
	public static void spaceToTime(int array[]) {
		int i = 0;
		int max = array[0];
		int l = array.length;
		for (i = 1; i < l; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		int[] temp = new int[max + 1];
		for (i = 0; i < l; i++) {
			temp[array[i]] = array[i];
		}
		int j = 0;
		int max1 = max + 1;
		for (i = 0; i < max1; i++) {
			if (temp[i] > 0) {
				array[j++] = temp[i];
			}
		}
	}
}
