package com.crazy.chapter18;

import java.util.Date;

import javax.swing.JFrame;

public class YeekuObjectFactory {

	public static Object getInstance(String clzName) {
		try {
			Class<?> clazz = Class.forName(clzName);
			return clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static <T> T getInstance2(Class<T> clazz) {
		try {
			return clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		Date d = (Date) YeekuObjectFactory.getInstance("java.util.Date");
		JFrame jf = YeekuObjectFactory.getInstance2(JFrame.class);
		System.out.println(d);
	}
}
