package com.crazy.chapter16.fourth.sync;

public class DeadLock implements Runnable {

	A a = new A();
	B b = new B();
	
	public void init() {
		Thread.currentThread().setName("main thread");
		a.foo(b);
		System.out.println("into main thread");
	}
	
	public void run() {
		Thread.currentThread().setName("sub thread");
		b.foo(a);
		System.out.println("into sub thread");
	}
	
	public static void main(String[] args) {
		DeadLock dl = new DeadLock();
		new Thread(dl).start();
		dl.init();
	}
}

class A {
	public synchronized void foo(B b) {
		System.out.println("current thread :" + Thread.currentThread().getName() + " into A");
		try {
			Thread.sleep(20);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("current thread :" + Thread.currentThread().getName() + " invoke B's last");
		b.last();
	}
	
	public synchronized void last() {
		System.out.println("into A's last method");
	}
}
class B {
	public synchronized void foo(A a) {
		System.out.println("current thread :" + Thread.currentThread().getName() + " into B");
		try {
			Thread.sleep(20);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("current thread :" + Thread.currentThread().getName() + " invoke A's last");
		a.last();
	}
	
	public synchronized void last() {
		System.out.println("into B's last method");
	}
}