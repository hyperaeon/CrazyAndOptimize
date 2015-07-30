package com.algorithm.classic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sumloop {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		sum1(reader.readLine());

	}

	public static void sum1(String input) {
		int sum = 0;
		String output = "";
		for (int i = 1; i <= Integer.parseInt(input); i++) {
			output += input;
			int a = Integer.parseInt(output);
			sum += a;
		}
		System.out.println(sum);
	}
}
