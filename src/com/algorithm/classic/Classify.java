package com.algorithm.classic;

import java.util.Scanner;

public class Classify {

	public static void main(String[] args) {
		 @SuppressWarnings("resource")
		 Scanner sc = new Scanner(System.in);
		 int number;
		 while(sc.hasNextInt()) {
			 number = sc.nextInt();
			 System.out.println((number > 90 ? "A" : (number < 60 ? "C" : "B")));
		 }
	}
}
