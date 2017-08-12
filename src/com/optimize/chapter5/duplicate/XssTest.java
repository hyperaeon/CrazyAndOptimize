package com.optimize.chapter5.duplicate;

public class XssTest {

	public static class MyThread extends Thread {
		
		@Override
		public void run() {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		int i = 0;
		try {
			for (i = 0; i < 100000; i++) {
				new MyThread().start();
			}
		} catch (OutOfMemoryError e) {
			System.out.println("count thread is " + i);
		}
	}
}
