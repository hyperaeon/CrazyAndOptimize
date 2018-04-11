package com.test.jdk8;

import java.time.Instant;
import java.util.Date;

public class InstantTest {

	public static void main(String[] args) {
		firstTest();
	}
	
	public static void firstTest() {
		Instant instant = Instant.now();
		System.out.println(instant);
		instant = Instant.ofEpochMilli(new Date().getTime());
		System.out.println(instant);
		instant = Instant.parse("2018-03-01T01:19:17.902Z");
		System.out.println(instant);
	}
}
