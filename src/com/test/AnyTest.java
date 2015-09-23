package com.test;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnyTest implements Serializable {
	
	private static final AtomicInteger counter = new AtomicInteger();
	
	
	private int value = 2;
	
	public AnyTest() {
		System.out.println("Constructor");
		counter.incrementAndGet();
	}
	
	public int getInstanceCount() {
		return counter.get();
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
		dateTest();
	}

	private void stringTest() {
		System.out.println("stringTest()");
	}

	private static void dateTest() {
		Date date = new Date(1443061349617L);
		System.out.println(date);
		System.out.println(new Date().getTime());
	}

	private static void iteratorTest() {
		// Iterator<String> iterator
	}

	private static void longAndLongTest() {
		Long a = 230L;
		Long b = 230L;
		System.out.println(b == a);
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
	
	private static void concurrentModificationExceptionTest() {
		List<String> list = new ArrayList<>();
		list.add("abc");
		list.add("bcd");
		for (String s : list) {
			System.out.println(s);
			list.add("dsfs");
		}
	}
	
	private static void bigDecimalTest() {
		BigDecimal big1 = BigDecimal.valueOf(680.00);
		BigDecimal big2 = BigDecimal.valueOf(680);
		System.out.println(big1.doubleValue() == big2.doubleValue());
	}
}
