package com.crazy.chapter16;

class DeadA {
	public synchronized void foo(DeadB b) {
		System.out.println("��ǰ�߳�����" + Thread.currentThread().getName()
				+ " ����A��foo����");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("����B��last����");
		b.last();
	}

	public synchronized void last() {
		System.out.println("A��last����");
	}
}

class DeadB {
	public synchronized void bar(DeadA a) {
		System.out.println("��ǰ�߳�����" + Thread.currentThread().getName()
				+ "����B��bar����");
		try {
			Thread.sleep(100);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		System.out.println("����a��last����");
		a.last();
	}

	public synchronized void last() {
		System.out.println("����B��last����");
	}
}

public class DeadLock implements Runnable {

	DeadA a = new DeadA();
	DeadB b = new DeadB();
	
	public void init() {
		Thread.currentThread().setName("���߳�");
		a.foo(b);
		System.out.println("�������߳�֮��");
	}
	@Override
	public void run() {
		Thread.currentThread().setName("���߳�");
		b.bar(a);
		System.out.println("���븱�߳�֮��");
	}

	public static void main(String[] args) {
		DeadLock l = new DeadLock();
		new Thread(l).start();
		l.init();
	}
}
