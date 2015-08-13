package com.test;

import java.io.Serializable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnyTest implements Serializable {
	public AnyTest() {
		System.out.println("Constructor");
	}

	{
		System.out.println("Normal block");
	}
	
	static {
		System.out.println("Static block");
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws Exception {
		new AnyTest();
	}
	

	private static void stringTest() {

	}

	private static void dateTest() {

	}

	private static void iteratorTest() {
		// Iterator<String> iterator
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

	private static void loggerTest() {
		Logger logger = Logger.getAnonymousLogger();
		logger.log(Level.INFO, "first info message");
	}

	private static void classTest() throws ClassNotFoundException {
		Class clazz = Class.forName("com.test.AnyTest");
		if (Serializable.class.isAssignableFrom(clazz)) {
			System.out.println("Same class");
		}
	}
	
	private static void eventListenerTest() {
	}
	
	private static void splitTest() {
		String str = "asdfasdf sfo  asldf sdf;#  ";
		String[] arr = str.split(";#[\\s+]");
		System.out.println(arr);
	}
	
	private static void threadTest() {
		Thread t = new Thread();
		t.start();
		try {
			Thread.sleep(1000);
			t.interrupt();
		} catch (Exception e) {
			
		}
		if (t.isAlive()) {
			t.interrupt();
			System.out.println(t.isAlive());
		}
		
	}
}
