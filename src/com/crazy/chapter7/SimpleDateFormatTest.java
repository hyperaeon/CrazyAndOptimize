package com.crazy.chapter7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {

	public static void main(String[] args) throws ParseException {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("Gyyyy���е�D��");
		String dateStr = sdf.format(d);
		System.out.println(dateStr);
		String str = "197###����##21";
		sdf = new SimpleDateFormat("y###MMM##d");
		System.out.println(sdf.parse(str));
	}
}
