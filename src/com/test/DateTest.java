package com.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTest {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//		System.out.println(new Date());
		long time = 1436763670000L;
		Date date = new Date(time);
		System.out.println(date);
		System.out.println(format.format(date));
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(date);
//		cal.setTimeZone(TimeZone.getTimeZone("GMT"));
//		System.out.println(cal.getTime());
		long time2 = 1436720830000L;
		Date date2 = new Date(time2);
		System.out.println(date2);
		System.out.println(format.format(date2));
		
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date3 = new Date();
//		String strDate = form.format(date3);
//		Date date4 = new Date(strDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date3);
		cal.set(date3.getYear() + 1900, date3.getMonth(), date3.getDate(), date3.getHours(), date3.getMinutes(), date3.getSeconds());
		System.out.println(date3.getTime());
		System.out.println(cal.getTime().getTime());
		
		Date currentDate = new Date();
		DateFormat format24 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time24 = format24.format(currentDate);
		currentDate = format24.parse(time24);
		Long currentTime = currentDate.getTime();
		System.out.println(currentTime);
	}
}
