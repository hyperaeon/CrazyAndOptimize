package com.algorithm.classic;

import java.util.Scanner;

public class WordStatistic {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String chineses = "[\u4e00-\u9fa5]";//中文的unicode
		String english = "[a-zA-Z]";//英文的正则表达式
		String space = "\\s";
		while (sc.hasNext()) {
			String str = sc.next();
			int countH = 0;//统计中文个数
			int countE = 0;//统计英文个数
			int countS = 0;
			char[] charArr = str.toCharArray();//将字符串转化成字符数组
			String[] strArr = new String[charArr.length];
			for (int i = 0; i < charArr.length; i++) {//将字符数组转化成字符串数组
				strArr[i] = String.valueOf(charArr[i]);
			}
			for (String s : strArr) {
				if (s.matches(chineses)) {
					countH++;
				}
				if (s.matches(english)) {
					countE++;
				}
				if (s.matches(space)) {
					countS++;
				}
			}
			System.out.println("中文个数：" + countH);
			System.out.println("英文个数：" + countE);
			System.out.println("空格个数：" + countS);
		}
	}
}
