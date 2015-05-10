package com.crazy.chapter16;

import java.util.Date;

public class ThreadTest {

	public static void main(String[] args)throws Exception{
		for(int i = 0; i < 10; i ++)
		{
			System.out.println("当前时间：" + new Date());
			Thread.sleep(1000);
		}
	}
}
