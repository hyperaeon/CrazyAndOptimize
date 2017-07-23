package com.jdk8.other;

import java.util.Arrays;

public class LambdaTest {

	public static void main(String[] args) {
		Arrays.asList("p", "k", "u").forEach(e -> System.out.println(e));
		Arrays.asList("p", "k", "u").forEach((String e) -> System.out.println(e));
		Arrays.asList("p", "k", "u").forEach(
				e -> {
					System.out.println(e);
					System.out.println(e);
				}
		);
		String separator = ",";
		Arrays.asList("a", "b", "c").forEach(
				(String e) -> System.out.println(e + separator)
		);
		Arrays.asList("a", "b", "d").sort((e1, e2) -> e1.compareTo(e2));
	}
}
