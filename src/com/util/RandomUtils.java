package com.util;

import java.util.Random;

import com.ip.constant.Constants;

public class RandomUtils {

	public static String getRandom(int number) {
		Random random = new Random();
		int num = random.nextInt(number);
		return String.valueOf(num);
	}
	
	/**
	 * 获取随机ip
	 * @param number
	 * @return
	 */
	public static String getRandomIp(int number) {
		String first = RandomUtils.getRandom(Constants.IP_MAX);
		String second = RandomUtils.getRandom(Constants.IP_MAX);
		String third = RandomUtils.getRandom(Constants.IP_MAX);
		String fourth = RandomUtils.getRandom(Constants.IP_MAX);
		return first + Constants.DOT + second + Constants.DOT + third + Constants.DOT + fourth;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10000; i ++) {
			String ip = getRandomIp(Constants.IP_MAX);
			System.out.println(i + " " + ip);
		}
	}
}
