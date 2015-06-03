package com.crazy.chapter16.duplicate;

class AlterA extends Thread {
	private String str;

	public AlterA(String str, String name) {
		super(name);
		this.str = str;
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			synchronized (str) {
				str.notify();
				System.out.println(getName() + "  " + i);
				try {
					str.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			synchronized(str) {
				str.notifyAll();
			}
		}
	}
}

public class AlterThread {

	public static void main(String[] args) {
		String str = "abc";
		AlterA aa = new AlterA(str, "线程A");
		AlterA ab = new AlterA(str, "线程B");
		aa.start();
		ab.start();
	}
}
