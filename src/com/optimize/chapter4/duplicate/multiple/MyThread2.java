package com.optimize.chapter4.duplicate.multiple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThread2 implements Runnable, Comparable<MyThread2>{
	
	protected String name;
	
	public MyThread2() {
		
	}
	
	public MyThread2(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(100);
			System.out.println(name + " ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int compareTo(MyThread2 o) {
		int me = Integer.parseInt(this.name.split("_")[1]);
		int other = Integer.parseInt(o.name.split("_")[1]);
		if (me > other) {
			return 1;
		} else if (me < other) {
			return -1;
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		ExecutorService exe = new ThreadPoolExecutor(100, 200, 0L, TimeUnit.SECONDS, new PriorityBlockingQueue<Runnable>());
		for (int i = 0; i < 1000; i++) {
			exe.execute(new MyThread2("testThreadExecutor3_" + Integer.toString(999 - i)));
		}
	}
}
