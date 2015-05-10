package com.crazy.chapter16.group;

class MyThreadGroup extends Thread {
	public MyThreadGroup(String name) {
		super(name);
	}

	public MyThreadGroup(ThreadGroup group, String name) {
		super(group, name);
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(getName() + "线程的i变量" + i);
		}
	}
}

public class ThreadGroupTest {

	public static void main(String[] args) {
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		System.out.println("主线程组的名称" + mainGroup.getName());
		System.out.println("主线程组是否为守护线程：" + mainGroup.isDaemon());
		new MyThreadGroup("主线程组的线程").start();
		ThreadGroup tg = new ThreadGroup("新线程组");
		tg.setDaemon(true);
		System.out.println("新线程组的名称:" + tg.getName());
		System.out.println("新线程组是否为守护线程：" + tg.isDaemon());
		new MyThreadGroup("新线程组的线程").start();
	}
}
