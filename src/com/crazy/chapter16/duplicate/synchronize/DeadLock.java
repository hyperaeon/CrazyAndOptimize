package com.crazy.chapter16.duplicate.synchronize;

class A {
	public synchronized void foo(B b) {
		System.out.println("��ǰ�̣߳� " + Thread.currentThread().getName()
				+ " ������Aʵ����foo����");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("��ǰ�̣߳� " + Thread.currentThread().getName()
				+ " ������Bʵ����last����");
		b.last();
	}

	public synchronized void last() {
		System.out.println("������A���last�����ڲ�");
	}
}

class B {
	public synchronized void bar(A a) {
		System.out.println("��ǰ�̣߳� " + Thread.currentThread().getName()
				+ " ������Bʵ����bar����");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("��ǰ�̣߳� " + Thread.currentThread().getName()
				+ " ������Aʵ����last����");
		a.last();
	}

	public synchronized void last() {
		System.out.println("������B���last�����ڲ�");
	}
}

public class DeadLock implements Runnable {

	A a = new A();
	B b = new B();

	public void init() {
		Thread.currentThread().setName("���߳�");
		a.foo(b);
		System.out.println("���������߳�֮��");
	}

	@Override
	public void run() {
		Thread.currentThread().setName("���߳�");
		b.bar(a);
		System.out.println("�����˸��߳�֮��");
	}

	public static void main(String[] args) {
		DeadLock dl = new DeadLock();
		new Thread(dl).start();
		dl.init();
	}
}
