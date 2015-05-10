package com.crazy.chapter16;

public class SecondThread implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 10; i ++){
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
	
	public static void main(String[] args){
		for(int i = 0; i < 100; i ++){
			System.out.println(Thread.currentThread().getName() + " " + i);
			if(i == 20){
				SecondThread st = new SecondThread();
				new Thread(st,"第一个线程").start();
				new Thread(st,"第二个线程").start();
			}
		}
		
	}

}
