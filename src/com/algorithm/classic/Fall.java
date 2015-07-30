package com.algorithm.classic;

public class Fall {

	public static void main(String[] args) {
		double sum = 0;
		double height = 100;
		for (int i = 1; i <= 10; i++) {
			sum += height;
			height = height / 2;
		}
		System.out.println("第10次下落时共经历了：" + sum);
		System.out.println("第10次反弹高度为：" + height);
	}
}
