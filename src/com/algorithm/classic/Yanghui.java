package com.algorithm.classic;

public class Yanghui {

	public static void main(String[] args) {
		int[][] ab = {{3,2,3},{1,2,4}};
		System.out.println(ab[0].length);
	}
	
	
	public static void printYanghui() {
		int[][] a = new int[10][10];
		int i = 0, j = 0;
		for (i = 0; i < 10; i++) {
			a[i][0] = 1;//First column
			a[i][i] = 1;//xie dui jiaoxian
		}
		for (i = 2; i < 10; i++) {
			for (j = 1; j < 10; j++) {
				a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
			}
		}
		
	}
}
