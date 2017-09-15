package com.crazy.chapter16.fourth;

public class SecondThread implements Runnable {

	private int i;
	@Override
	public void run() {
		for (; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 20) {
				SecondThread st = new SecondThread();
				new Thread(st, "线程1").start();
				new Thread(st, "线程2").start();
			}
		}
	}
	

}
