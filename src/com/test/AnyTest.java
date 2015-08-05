package com.test;

import java.awt.event.AWTEventListenerProxy;
import java.io.Serializable;
import java.util.EventListener;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnyTest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws Exception {
		classTest();
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
}
