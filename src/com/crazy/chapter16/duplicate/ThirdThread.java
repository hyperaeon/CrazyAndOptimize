package com.crazy.chapter16.duplicate;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThirdThread implements Callable<Integer> {

	public Integer call() {
		int i = 0;
		for (; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
		return i;
	}

	public static void main(String[] args) {
		ThirdThread tt = new ThirdThread();
		FutureTask<Integer> ft = new FutureTask<>(tt);
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 20) {
				new Thread(ft, "�з���ֵ���߳�").start();
			}
		}
		try {
			System.out.println("���̵߳ķ���ֵ��" + ft.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
