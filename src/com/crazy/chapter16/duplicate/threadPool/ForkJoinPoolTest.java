package com.crazy.chapter16.duplicate.threadPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

class PrintTask extends RecursiveAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int THRESHOLD = 50;
	private int start;
	private int end;

	public PrintTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	protected void compute() {
		if (end - start < THRESHOLD) {
			for (int i = start; i < end; i++) {
				System.out.println(Thread.currentThread().getName() + "µÄiÖµ£º"
						+ i);
			}
		} else {
			int middle = (start + end) / 2;
			PrintTask left = new PrintTask(start, middle);
			PrintTask right = new PrintTask(middle, end);
			left.fork();
			right.fork();
		}
	}
}

public class ForkJoinPoolTest {

	public static void main(String[] args) throws Exception {
		ForkJoinPool pool = new ForkJoinPool();
		pool.submit(new PrintTask(0, 300));
		pool.awaitTermination(2, TimeUnit.SECONDS);
		pool.shutdown();
	}
}
