package com.crazy.chapter16.duplicate;

import java.util.Date;

public class SleepTest {

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 10; i++) {
			System.out.println("��ǰʱ�䣺" + new Date());
			Thread.sleep(1000);
		}
	}
}
