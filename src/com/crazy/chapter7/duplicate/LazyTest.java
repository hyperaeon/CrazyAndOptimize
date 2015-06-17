package com.crazy.chapter7.duplicate;

import java.util.Calendar;

public class LazyTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(2003, 7, 31);
		cal.set(Calendar.MONTH, 8);
		cal.set(Calendar.DATE, 5);
		System.out.println(cal.getTime());
	}
}
