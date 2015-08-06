package com.crazy.chapter16.duplicate.threadGroup;

class MyExHandler implements Thread.UncaughtExceptionHandler {
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(t + " �̳߳������쳣��" + e);
	}
}

public class ExHandler {

	public static void main(String[] args) {
		Thread.currentThread().setUncaughtExceptionHandler(new MyExHandler());
		int a = 5 / 0;
		System.out.println("�������߽���");
	}
}
