package com.optimize.chapter4.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Main {

	public static void main(String[] args) 
			throws InterruptedException, ExecutionException {
		FutureTask<String> future = new FutureTask<String>(new RealData("a"));
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.submit(future);
		System.out.println("请求完毕");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		System.out.println("shuju=" + future.get());
		
	}
}
