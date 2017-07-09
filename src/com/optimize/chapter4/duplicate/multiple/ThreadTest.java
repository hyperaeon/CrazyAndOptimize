package com.optimize.chapter4.duplicate.multiple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {

	public static void main(String[] args) {
		threadWithExecutor();
		threadWithoutPool();
		threadWithPool();
	}
	
	public static void threadWithExecutor() {
		int total = 10000;
		ExecutorService exe = Executors.newCachedThreadPool();
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			exe.execute(new MyThread("testJDKThreadPool" + Integer.toString(i)));
		}
		System.out.println(System.currentTimeMillis() - start);
	}
	
	public static void threadWithoutPool() {
		int total = 10000;
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			new Thread(new MyThread("testNoThreadPool" + Integer.toString(i))).start();
		}
		System.out.println(System.currentTimeMillis() - start);
	}
	
	public static void threadWithPool() {
		int total = 10000;
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			ThreadPool.getInstance().start(new MyThread("testNoThreadPool" + Integer.toString(i)));
		}
		System.out.println(System.currentTimeMillis() - start);
	}
}
