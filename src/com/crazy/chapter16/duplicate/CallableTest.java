package com.crazy.chapter16.duplicate;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		int i = 0;
		for (; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " 的循环变量i的值："
					+ i);
		}
		return i;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CallableTest test = new CallableTest();
		FutureTask<Integer> future = new FutureTask<Integer>(test);
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " 的循环变量i的值："
					+ i);
			if (i == 20) {
//				System.out.println("子线程的返回值：" + future.get());//死锁
				new Thread(future, "有返回值的线程").start();
			}
		}
		try {
			System.out.println("子线程的返回值：" + future.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
