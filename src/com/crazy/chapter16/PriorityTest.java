package com.crazy.chapter16;

public class PriorityTest extends Thread {

	public PriorityTest(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(getName() + ",优先级是 " + getPriority()
					+ "，循环变量的值为：" + i);
		}
	}

	public static void main(String[] args) {
		Thread.currentThread().setPriority(6);
		for (int i = 0; i < 30; i++) {
			if (i == 10) {
				PriorityTest low = new PriorityTest("低级线程");
				low.start();
				System.out.println("创建之初的优先级：" + low.getPriority());
				low.setPriority(Thread.MIN_PRIORITY);
			}
			if (i == 20) {
				PriorityTest high = new PriorityTest("高级线程");
				high.start();
				System.out.println("创建之初的优先级：" + high.getPriority());
				high.setPriority(Thread.MAX_PRIORITY);
			}
		}
	}
}
