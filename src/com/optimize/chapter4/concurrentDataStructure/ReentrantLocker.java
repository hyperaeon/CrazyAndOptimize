package com.optimize.chapter4.concurrentDataStructure;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocker {

	private static ReentrantLock lock = new ReentrantLock();

	private static Runnable createTask() {
		return new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						if (lock.tryLock(500, TimeUnit.MILLISECONDS)) {
							try {
								System.out.println("locked "
										+ Thread.currentThread().getName());
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							} finally {
								lock.unlock();
							}
						} else {
							System.out.println("unable to lock"
									+ Thread.currentThread().getName());
						}
					} catch (InterruptedException e) {
						System.out.println(Thread.currentThread().getName()
								+ " is interrupted");
						e.printStackTrace();
					}
				}
			}
		};
	}

	public static void main(String[] args) throws Exception {
		Thread first = new Thread(createTask(), "FirstThread");
		Thread second = new Thread(createTask(), "SecondThread");
		first.start();
		second.start();
		Thread.sleep(1000);
		second.interrupt();
	}
}
