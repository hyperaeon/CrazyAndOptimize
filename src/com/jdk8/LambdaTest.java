package com.jdk8;

import java.util.Arrays;

public class LambdaTest {

	public static void main(String[] args) {
		Arrays.asList("p", "k", "u").forEach(e -> System.out.println(e));
	}
}
