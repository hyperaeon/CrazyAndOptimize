package com.test;

public class SplitTest {

	private static String COMMA = ",";
	
	public static void main(String[] args) {
		String source = "yang_linji@163.com";
		String[] arr = source.split(",");
		arrLengtStatistic(arr);
		System.out.println("字符串长度：" + source.length());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3449; i++) {
			if (i == 3448) {
				sb.append(source);
			} else {
				sb.append(source).append(COMMA);
			}
		}
		System.out.println(sb.toString());
		arr = sb.toString().split(",");
		arrLengtStatistic(arr);
		
	}
	
	public static void arrLengtStatistic(String[] arr) {
		System.out.println("数组长度：" + arr.length);
	}
}
