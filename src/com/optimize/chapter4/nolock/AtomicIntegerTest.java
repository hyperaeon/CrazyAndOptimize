package com.optimize.chapter4.nolock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

	private static final int MAX_THREADS = 3;
	
	private static final int TASK_COUNT = 3;
	
	private static final int TARGET_COUNT = 100000;
	
	private AtomicInteger acount = new AtomicInteger(0);

	private int count = 0;
	
	protected synchronized int inc() {
		return ++count;
	}
	
	protected synchronized int getCount() {
		return count;
	}
	
	public class SyncThread implements Runnable {
		protected String name;
		
		protected long startTime;
		
		AtomicIntegerTest out;
		
		public SyncThread(AtomicIntegerTest o, long startTime) {
			out = o;
			this.startTime = startTime;
		}
		
		@Override
		public void run() {
			int v = out.inc();
			while (v < TARGET_COUNT) {
				v = out.inc();
			}
			long endTime = System.currentTimeMillis();
			System.out.println("SyncThread spend: " + (endTime - startTime) + "ms" + " v=" + v);
		}
	}
	
	
	public class AtomicThread implements Runnable {
		protected String name;
		
		protected long startTime;
		
		public AtomicThread(long startTime) {
			this.startTime = startTime;
		}
		
		@Override
		public void run() {
			int v = acount.incrementAndGet();
			while (v < TARGET_COUNT) {
				v = acount.incrementAndGet();
			}
			long endTime = System.currentTimeMillis();
			System.out.println("AtomicThread spend:" + (endTime - startTime) + "ms v=" + v);
		}
	}
	
	public void testAtomic() throws InterruptedException {
		ExecutorService exe = Executors.newFixedThreadPool(MAX_THREADS);
		long startTime = System.currentTimeMillis();
		AtomicThread atomic = new AtomicThread(startTime);
		for (int i = 0; i < TASK_COUNT; i++) {
			exe.submit(atomic);
		}
		Thread.sleep(10000);
	}
	
	public void testSync() throws InterruptedException {
		ExecutorService exe = Executors.newFixedThreadPool(MAX_THREADS);
		long startTime = System.currentTimeMillis();
		SyncThread sync = new SyncThread(this, startTime);
		for (int i = 0; i < TASK_COUNT; i++) {
			exe.submit(sync);
		}
		Thread.sleep(10000);
	}
	
	public static void main(String[] args) throws Exception {
		AtomicIntegerTest test = new AtomicIntegerTest();
		test.testAtomic();
		test.testSync();
	}
}
