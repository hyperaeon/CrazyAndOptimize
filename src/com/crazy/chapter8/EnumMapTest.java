package com.crazy.chapter8;

import java.util.EnumMap;

public class EnumMapTest {

	public static void main(String[] args){
		EnumMap enumMap = new EnumMap(Season.class);
		enumMap.put(Season.WINTER, "����");
		enumMap.put(Season.SUMMER, "����");
		System.out.println(enumMap);
	}
}
