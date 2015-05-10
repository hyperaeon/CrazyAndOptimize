package com.crazy.chapter7;

import java.util.Calendar;

public class LenientTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, 13);
		System.out.println(cal.getTime());
		cal.setLenient(false);
		cal.set(Calendar.MONTH, 13);
		System.out.println(cal.getTime());
	}
}
