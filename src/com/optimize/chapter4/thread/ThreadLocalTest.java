package com.optimize.chapter4.thread;

import java.util.Date;


public class ThreadLocalTest implements Runnable{

	public static final ThreadLocal<Date> local = new ThreadLocal<Date>();
	
	private long time;
	
	public ThreadLocalTest(long time) {
		this.time = time;
	}
	
	@Override
	public void run() {
		Date d = new Date(time);
		for (int i = 0; i < 50000; i++) {
			local.set(d);
			if (local.get().getTime() != time) {
				System.out.println("i=" + i);
			}
		}
		
	}

}
