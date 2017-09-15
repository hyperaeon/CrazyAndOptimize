package com.crazy.chapter16.fourth;

public class JoinThread extends Thread {

	public JoinThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(getName() + " " + i);
		}
	}
	public static void main(String[] args) throws Exception {
		new JoinThread("���߳�").start();
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 20) {
				JoinThread jt = new JoinThread("join�߳�");
				jt.start();
				jt.join();
			}
		}
	}
}
