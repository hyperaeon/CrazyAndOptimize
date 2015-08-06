package com.crazy.chapter10;

import java.util.Date;

public class NullTest {

	public static void main(String[] args) {
		Date d = null;
		try {
			System.out.println(d.after(new Date()));
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("空指针异常");
		} catch (Exception e) {
			System.out.println("未知异常");
		}
	}
}
