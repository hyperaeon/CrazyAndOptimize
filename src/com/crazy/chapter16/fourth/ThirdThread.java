package com.crazy.chapter16.fourth;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThirdThread implements Callable<Integer> {

	public Integer call() {
		int i = 0;
		for (; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " i: " + i);
		}
		return i;
	}
	
	public static void main(String[] args) {
		ThirdThread rt = new ThirdThread();
		FutureTask<Integer> task = new FutureTask<>(rt);
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " i: " + i);
			if (i == 20) {
				new Thread(task, "�з���ֵ���߳�").start();
			}
		}
		try {
			System.out.println("���̵߳ķ���ֵ��" + task.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
