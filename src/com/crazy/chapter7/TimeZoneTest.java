package com.crazy.chapter7;

import java.util.TimeZone;

public class TimeZoneTest {

	public static void main(String[] args) {
		String[] ids = TimeZone.getAvailableIDs();
		TimeZone my = TimeZone.getDefault();
		System.out.println(my.getID());
		System.out.println(my.getDisplayName());
		System.out.println(TimeZone.getTimeZone("CNT").getDisplayName());
		
		while(true) {
			System.out.println("befor break;");
			if (1 == 1) {
				break;
			}
			System.out.println("after break;");
		}
	}
}
