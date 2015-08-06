package com.crazy.chapter16.duplicate;

public class DaemonThread extends Thread {

	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(getName() + " " + i);
		}
	}
	
	public static void main(String[] args) {
		DaemonThread dt = new DaemonThread();
		dt.setDaemon(true);
		dt.start();
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			System.out.println("Is dt alive" + dt.isAlive());
		}
		System.out.println("After for Is dt alive" + dt.isAlive());
	}
}
