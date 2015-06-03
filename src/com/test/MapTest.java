package com.test;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {

	public static void main(String[] args) {
		String abc = "HPS_USD_EUR";
		String[] strArr = new String[3];
		strArr = abc.split("_");
		for (String str : strArr) {
			System.out.println(str);
		}
		TreeMap<Integer, String> map = new TreeMap<>();
		map.put(1,"abc");
		map.put(0,"bcd");
		map.put(2,"def");
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
		BigDecimal bd = new BigDecimal("0.00");
		System.out.println(bd.doubleValue() == Double.parseDouble("0.0000"));
	}
}
