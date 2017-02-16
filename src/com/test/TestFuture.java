package com.test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestFuture {

	static class Job<Object> implements Callable<Object> {

		@Override
		public Object call() throws Exception {
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return (Object)"abc";
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		FutureTask<Object> future = new FutureTask<Object>(new Job<Object>());
		new Thread(future).start();
		System.out.println("执行future中...");
		Object result = future.get();
		System.out.println(result);
	}
}
