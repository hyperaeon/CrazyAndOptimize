package com.optimize.chapter4.producerConsumer;


public class ThreadWithCompare implements Runnable,
		Comparable<ThreadWithCompare> {

	protected String name;

	public ThreadWithCompare() {

	}

	public ThreadWithCompare(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(100);
			System.out.println(name + " ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int compareTo(ThreadWithCompare o) {
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

}
