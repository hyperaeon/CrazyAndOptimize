package com.crazy.chapter16.group;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class MyExHandler implements Thread.UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(t + " �̳߳����쳣��" + e);
	}

}

public class ExHandler {

	public static void main(String[] args) {
		Thread.currentThread().setUncaughtExceptionHandler(new MyExHandler());
		int a = 5 / 0;
		System.out.println("������������");
	}
}
