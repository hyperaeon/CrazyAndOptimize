package com.effective.chapter10;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {

	public static void main(String[] args) throws InterruptedException {
		int concurrency = 3;
		ExecutorService executor = Executors.newFixedThreadPool(concurrency);
		long time = time(executor, concurrency, new Runnable() {
			public void run() {
				System.out.println("run...");
			}
		});
		System.out.println("waste time:" + time);
	}
	
	public static long time(Executor executor, int concurrency,
			final Runnable action) throws InterruptedException {
		final CountDownLatch ready = new CountDownLatch(concurrency);
		final CountDownLatch start = new CountDownLatch(1);
		final CountDownLatch done = new CountDownLatch(concurrency);
		for (int i = 0; i < concurrency; i++) {
			executor.execute(new Runnable() {
				public void run() {
					ready.countDown();
					try {
						start.await();
						action.run();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					} finally {
						done.countDown();
					}
				}
			});
		}
		ready.await();
		long startNanos = System.nanoTime();
		start.countDown();
		done.await();
		return System.nanoTime() - startNanos;
	}
}
