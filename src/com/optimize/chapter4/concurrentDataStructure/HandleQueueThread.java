package com.optimize.chapter4.concurrentDataStructure;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class HandleQueueThread implements Runnable {

	protected String name;

	private Queue<Integer> q;

	Random rand = new Random();

	public HandleQueueThread() {

	}

	public HandleQueueThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 500; i++) {
				handleQueue(rand.nextInt(1000));
			}
			Thread.sleep(rand.nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Object handleQueue(int index) {
		q.add(index);
		q.poll();
		return null;
	}

	public void initConcurrentLinkedQueue() {
		q = new ConcurrentLinkedQueue<Integer>();
		for (int i = 0; i < 300; i++) {
			q.add(i);
		}
	}

	public void initLinkedBlockingQueue() {
		q = new LinkedBlockingQueue<>();
		for (int i = 0; i < 300; i++) {
			q.add(i);
		}
	}
}
