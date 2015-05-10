package com.optimize.chapter4.control;

import com.crazy.chapter14.TestNG;

public class VolatileTest {

	volatile boolean isExist;

	public void tryExist() {
		if (isExist == !isExist) {
			System.exit(0);
		}
	}

	public void swapValue() {
		isExist = !isExist;
	}

	@TestNG
	public void test() throws InterruptedException {
		final VolatileTest test = new VolatileTest();
		Thread myThread = new Thread() {
			public void run() {
				System.out.println("myThread start");
				while (true) {
					test.tryExist();
				}
			}
		};
		myThread.start();
		Thread seThread = new Thread() {
			public void run() {
				System.out.println("seThread start");
				while (true) {
					test.swapValue();
				}
			}
		};
		seThread.start();
		Thread.sleep(1000);
		
	}
}
