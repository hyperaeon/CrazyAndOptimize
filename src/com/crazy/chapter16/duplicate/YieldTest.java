package com.crazy.chapter16.duplicate;

public class YieldTest extends Thread {

	public YieldTest(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(getName() + " " + i);
			if (i == 20) {
				Thread.yield();
			}
		}
	}

	public static void main(String[] args) {
		YieldTest y1 = new YieldTest("¸ß¼¶");
		y1.setPriority(Thread.MAX_PRIORITY);
		y1.start();
		YieldTest y2 = new YieldTest("µÍ¼¶");
		y2.setPriority(Thread.MIN_PRIORITY);
		y2.start();
	}
}
