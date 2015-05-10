package com.optimize.chapter4.concurrentDataStructure;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class AccessListThread extends Thread {

	private static final int MAX_THREADS = 2000;
	private static final int TASK_COUNT = 2000;

	protected String name;

	Random rand = new Random();

	private List<String> list = new CopyOnWriteArrayList<>();

	public AccessListThread() {
	}

	public AccessListThread(String name) {
		this.name = name;
	}

	public void run() {
		try {
			for (int i = 0; i < 500; i++) {
				getList(rand.nextInt(1000));
				Thread.sleep(rand.nextInt());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Object getList(int index) {
		return list.get(index);
	}

	public static void main(String[] args) {
		CounterPoolExecutor exe = new CounterPoolExecutor(MAX_THREADS,
				MAX_THREADS, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());
		long start = System.currentTimeMillis();
		exe.startTime = start;
		exe.functionName = "testGetCopyOnWriteList";
		for (int i = 0; i < TASK_COUNT; i++) {
			exe.submit(new AccessListThread());
		}
	}
}
