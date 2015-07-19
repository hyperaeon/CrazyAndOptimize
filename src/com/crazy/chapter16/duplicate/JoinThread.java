package com.crazy.chapter16.duplicate;

public class JoinThread extends Thread {

	public JoinThread(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(getName() + " " + i);
		}
	}

	public static void main(String[] args) throws Exception {
		new JoinThread("new thread").start();
		for (int i = 0; i < 200; i++) {
			if (i == 20) {
				JoinThread jt = new JoinThread("被join的线程");
				jt.start();
				jt.join();
			}
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}
