package com.crazy.chapter7;

import java.util.Calendar;

public class CalendarTest2 {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH));
		System.out.println(c.get(Calendar.DATE));
		c.set(2015, 2, 9, 21, 51);
		c.add(Calendar.YEAR, -1);
		c.roll(Calendar.MONTH, -12);
		System.out.println(c.getTime());
	}
}
