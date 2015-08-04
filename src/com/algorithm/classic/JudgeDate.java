package com.algorithm.classic;

import java.util.Scanner;

public class JudgeDate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String yearStr = sc.next();
			String monthStr = sc.next();
			String dayStr = sc.next();
			int year = 0;
			int month = 0;
			int day = 0;
			try {
				year = Integer.parseInt(yearStr);
				month = Integer.parseInt(monthStr);
				day = Integer.parseInt(dayStr);
			} catch (NumberFormatException e) {
				System.out.println("Input invalid");
				System.exit(0);
			}
			validateInput(year, month, day);
			// method1
			judge1(year, month, day);
			// method2
			judge2(year, month, day);
		}
	}

	/**
	 * original method.
	 */
	public static void judge1(int year, int month, int day) {
		int sum = 0;
		switch (month) {
		case 1:
			sum = 0;
			break;
		case 2:
			sum = 31;
			break;
		case 3:
			sum = 59;
			break;
		case 4:
			sum = 90;
			break;
		case 5:
			sum = 120;
			break;
		case 6:
			sum = 151;
			break;
		case 7:
			sum = 181;
			break;
		case 8:
			sum = 212;
			break;
		case 9:
			sum = 243;
			break;
		case 10:
			sum = 273;
			break;
		case 11:
			sum = 304;
			break;
		case 12:
			sum = 334;
			break;
		default:
			System.out.println("data error");
			break;
		}
		sum += day;
		if (isLeap(year) && month > 2) {
			sum++;
		}
		System.out.println("It's the " + sum + " day of the year");
	}

	/**
	 * method2
	 */
	public static void judge2(int year, int month, int day) {
		int[] days = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };
		int sum = days[month - 1] + day;
		if (isLeap(year) && month > 2) {
			sum++;
		}
		System.out.println("It's the " + sum + " day of the year");
	}

	/**
	 * validate if year, month, day is valid.
	 * 
	 * @param year
	 * @param month
	 * @param day
	 */
	private static void validateInput(int year, int month, int day) {
		if (year < 0) {
			System.out.println("The year is invalid, please input again!");
			System.exit(0);
		}
		if (month < 0 || month > 12) {
			System.out.println("The month is invalid, please input again!");
			System.exit(0);
		}
		if (day < 0) {
			System.out.println("The day is invalid, please input again!");
			System.exit(0);
		}
		if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8
				|| month == 10 || month == 12)
				&& day > 31) {
			System.out.println("The day is invalid, please input again!");
			System.exit(0);
		} else if ((month == 4 || month == 6 || month == 9 || month == 11)
				&& day > 30) {
			System.out.println("The day is invalid, please input again!");
			System.exit(0);
		} else if (month == 2
				&& ((isLeap(year) && day > 29) || (!isLeap(year) && day > 28))) {
			System.out.println("The day is invalid, please input again!");
			System.exit(0);
		}

	}

	/**
	 * judge if the year is leap year.
	 * 
	 * @param year
	 * @return
	 */
	private static boolean isLeap(int year) {
		if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
			return true;
		}
		return false;
	}
}
