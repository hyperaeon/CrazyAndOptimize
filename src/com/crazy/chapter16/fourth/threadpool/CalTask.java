package com.crazy.chapter16.fourth.threadpool;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class CalTask extends RecursiveTask<Integer> {

	private static final int THREASHOLD = 20;
	
	private int arr[];
	
	private int start;
	
	private int end;
	
	public CalTask(int[] arr, int start, int end) {
		this.arr = arr;
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected Integer compute() {
		int sum = 0;
		if (end - start < THREASHOLD) {
			for (int i = start; i < end; i++) {
				sum += arr[i];
			}
			return sum;
		} else {
			int middle = (start + end) / 2;
			CalTask left = new CalTask(arr, start, middle);
			CalTask right = new CalTask(arr, middle, end);
			left.fork();
			right.fork();
			return left.join() + right.join();
		}
	}

	public static void main(String[] args) throws Exception {
		int[] arr = new int[100];
		Random rand = new Random();
		int total = 0;
		for (int i = 0, len = arr.length; i < len; i++) {
			int tmp = rand.nextInt(20);
			total += (arr[i] = tmp);
		}
		System.out.println(total);
		ForkJoinPool pool = new ForkJoinPool();
		Future<Integer> future = pool.submit(new CalTask(arr, 0, arr.length));
		System.out.println(future.get());
		pool.shutdown();
	}
}
