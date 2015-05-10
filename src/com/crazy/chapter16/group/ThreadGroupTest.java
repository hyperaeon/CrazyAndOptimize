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
			System.out.println(getName() + "�̵߳�i����" + i);
		}
	}
}

public class ThreadGroupTest {

	public static void main(String[] args) {
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		System.out.println("���߳��������" + mainGroup.getName());
		System.out.println("���߳����Ƿ�Ϊ�ػ��̣߳�" + mainGroup.isDaemon());
		new MyThreadGroup("���߳�����߳�").start();
		ThreadGroup tg = new ThreadGroup("���߳���");
		tg.setDaemon(true);
		System.out.println("���߳��������:" + tg.getName());
		System.out.println("���߳����Ƿ�Ϊ�ػ��̣߳�" + tg.isDaemon());
		new MyThreadGroup("���߳�����߳�").start();
	}
}
