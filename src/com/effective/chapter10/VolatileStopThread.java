package com.effective.chapter10;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class VolatileStopThread {
	private static volatile boolean stopRequested;

	private static volatile AtomicLong nextSerialNumber = new AtomicLong();
	
	public static void main(String[] args) throws InterruptedException {
		Thread backgroudThread = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				while (!stopRequested) {
					i++;
				}
			}
		});
		backgroudThread.start();
		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
	}
	
	public static long generateSerialNumber() {
		return nextSerialNumber.getAndIncrement();
	}
}
