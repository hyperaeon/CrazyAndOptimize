package com.crazy.chapter7;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date);
	}
}
