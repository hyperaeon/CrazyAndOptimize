package com.crazy.chapter16.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThread implements Runnable {
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "µÄiÖµ" + i);
		}
	}
}

public class ThreadPoolTest {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(6);
		service.submit(new MyThread());
		service.submit(new MyThread());
		service.shutdown();
	}
}
