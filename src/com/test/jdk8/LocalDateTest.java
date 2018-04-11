package com.test.jdk8;

import java.time.LocalDate;

public class LocalDateTest {

	public static void main(String[] args) {
		currentDateTest();
		yearMonthDayTest();
	}
	
	private static void currentDateTest() {
		LocalDate today = LocalDate.now();
		System.out.println(today);
	}
	
	private static void yearMonthDayTest() {
		LocalDate today = LocalDate.now();
		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
		System.out.printf("Year : %d month : %d day : %d \t %n", year, month, day);
	}
}
