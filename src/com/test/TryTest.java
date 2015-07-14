package com.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TryTest {

	public static void main(String[] args) throws ParseException {
		Date currentDate = new Date();
		DateFormat format24 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time24 = format24.format(currentDate);
//		try {
			format24.parse("sd").getTime();
//		} catch (ParseException e1) {
//			e1.printStackTrace();
//		}
		System.out.println("After try");
	}
}
