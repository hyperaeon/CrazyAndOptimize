package com.optimize.chapter4.duplicate.parallel;

public class VolatileTest {

	volatile boolean isExit;
	
	public void tryExit() {
		if (isExit == !isExit) {
			System.exit(0);
		}
	}
	
	public void swapValue() {
		isExit = !isExit;
	}
	
	public static void main(String[] args) throws Exception {
		test();
	}
	
	public static void test() throws Exception {
		final VolatileTest volObj = new VolatileTest();
		Thread mainThread = new Thread() {
			public void run() {
				System.out.println("mainThread start");
				while(true) {
					volObj.tryExit();
				}
			}
		};
		mainThread.start();
		
		Thread swapThread = new Thread() {
			public void run() {
				System.out.println("swapThread start");
				while(true) {
					volObj.swapValue();
				}
			}
		};
		swapThread.start();
		Thread.sleep(1000);
	}
}
