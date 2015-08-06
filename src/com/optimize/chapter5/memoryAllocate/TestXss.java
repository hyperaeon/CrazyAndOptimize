package com.optimize.chapter5.memoryAllocate;

public class TestXss {

	public static class MyThread extends Thread {
		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		int i = 0;
		try {
			for (i = 0; i < 10000; i++) {
				new MyThread().start();
			}
		} catch (OutOfMemoryError e) {
			System.out.println("count thread is " + i);
		}
	}
}
