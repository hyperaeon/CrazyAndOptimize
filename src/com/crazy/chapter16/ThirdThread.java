package com.crazy.chapter16;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThirdThread implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		int i;
		for(i = 0; i < 100; i++){
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
		return i;
	}
	
	public static void main(String[] args){
		ThirdThread tt = new ThirdThread();
		FutureTask<Integer> ft = new FutureTask<>(tt);
		for(int i = 0; i < 50; i ++){
			System.out.println(Thread.currentThread().getName() + " " + i);
			if(i == 20){
				new Thread(ft,"第一线程").start();
				new Thread(ft,"第二线程").start();
			}
		}
		try {
			System.out.println("task的返回值" + ft.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
