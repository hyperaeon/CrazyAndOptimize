package com.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutorService {

	static class Job implements Runnable {
		
		@Override
		public void run() {
			doWork();
		}
		
		private void doWork() {
			System.out.println("doing...");
		}
	}
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for (int i = 0 ; i < 10; i++) {
			exec.execute(new Job());
		}
	}
}
