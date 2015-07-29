package com.crazy.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {

	public static void main(String[] args) throws ParseException {
		String dateStr = "01/01/2015";
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date dt = format.parse(dateStr);
		System.out.println(dt);
	}
}
