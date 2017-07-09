package com.optimize.chapter4.duplicate.multiple;

public class MyThread implements Runnable {

	protected String name;
	
	public MyThread() {
		
	}
	
	public MyThread(String name) {
		this.name = name;
	}

	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
