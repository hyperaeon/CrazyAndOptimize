package com.optimize.chapter4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Client client = new Client();
		Data data = client.request("name");
		System.out.println("请求完毕");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}
		System.out.println("数据 = " + data.getResult());

		FutureTask<String> future = new FutureTask<String>(new RealData("a"));
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.submit(future);
		System.out.println("请求完毕");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}
		System.out.println("数据 = " + future.get());
	}
}
