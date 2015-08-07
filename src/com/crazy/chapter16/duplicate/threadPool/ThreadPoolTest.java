package com.crazy.chapter16.duplicate.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThread implements Runnable {
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "µÄiÖµÎª£º" + i);
		}
	}
}

public class ThreadPoolTest {

	public static void main(String[] args) throws Exception {
		ExecutorService pool = Executors.newFixedThreadPool(6);
		pool.submit(new MyThread());
		pool.submit(new MyThread());
		pool.shutdown();
	}
}
