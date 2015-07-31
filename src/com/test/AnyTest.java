package com.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;


public class AnyTest {

	public static void main(String[] args) {
	}
	
	
	private static void stringTest() {
		
	}
	
	private static void dateTest() {
		
	}
	
	private static void iteratorTest() {
//		Iterator<String> iterator
	}
	
	public static void ExecutorServiceTest() {
		ExecutorService service = Executors.newCachedThreadPool();
		FutureTask<String> task = new FutureTask<String>(new Cal());
		service.submit(task);
	}
	
	private static class Cal implements Callable<String> {

		@Override
		public String call() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
