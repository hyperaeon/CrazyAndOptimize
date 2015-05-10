package com.crazy.chapter16;

class DeadA {
	public synchronized void foo(DeadB b) {
		System.out.println("当前线程名：" + Thread.currentThread().getName()
				+ " 进入A的foo方法");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("进入B的last方法");
		b.last();
	}

	public synchronized void last() {
		System.out.println("A的last方法");
	}
}

class DeadB {
	public synchronized void bar(DeadA a) {
		System.out.println("当前线程名：" + Thread.currentThread().getName()
				+ "进入B的bar方法");
		try {
			Thread.sleep(100);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		System.out.println("进入a的last方法");
		a.last();
	}

	public synchronized void last() {
		System.out.println("进入B的last方法");
	}
}

public class DeadLock implements Runnable {

	DeadA a = new DeadA();
	DeadB b = new DeadB();
	
	public void init() {
		Thread.currentThread().setName("主线程");
		a.foo(b);
		System.out.println("进入主线程之后");
	}
	@Override
	public void run() {
		Thread.currentThread().setName("副线程");
		b.bar(a);
		System.out.println("进入副线程之后");
	}

	public static void main(String[] args) {
		DeadLock l = new DeadLock();
		new Thread(l).start();
		l.init();
	}
}
