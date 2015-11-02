package com.effective.chapter10;

import java.util.concurrent.TimeUnit;

public class StopThread {

	private static boolean stopRequested;

	private static synchronized void requestStop() {
		stopRequested = true;
	}
	
	private static synchronized boolean stopRequested() {
		return stopRequested;
	}
	public static void main(String[] args) throws InterruptedException {
		Thread backgroudThread = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				while (!stopRequested()) {
					i++;
				}
			}
		});
		backgroudThread.start();
		TimeUnit.SECONDS.sleep(1);
		requestStop();
	}
}
