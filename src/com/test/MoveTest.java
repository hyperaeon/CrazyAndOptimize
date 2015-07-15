package com.test;


public class MoveTest {

	public static void main(String[] args) {
		System.out.println(1 << 2);
		System.out.println(-1L << 7);
		System.out.println( (long)(-128 ^ -1));
		int h = 8;
		h ^= (h >>> 2) ^ (h >>> 1);
        int result = h ^ (h >>> 7) ^ (h >>> 4);
        System.out.println(result);
	}
}
