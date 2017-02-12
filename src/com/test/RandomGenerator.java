package com.test;

import java.util.Random;

public class RandomGenerator {

	private static String range = "01234567889abcdefghijklmnopqrstuvwxyz";
	
	public static synchronized String getRandomString() {
		Random random = new Random();
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < 8; i ++) {
			result.append(range.charAt(random.nextInt(range.length())));
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(RandomGenerator.getRandomString());
	}
}
