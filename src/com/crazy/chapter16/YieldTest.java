package com.crazy.chapter16;

public class YieldTest extends Thread {

	public YieldTest(String name){
		super(name);
	}
	
	public void run(){
		for(int i = 0;i < 100; i ++){
			System.out.println(Thread.currentThread().getName() + " " + i);
			if(i == 20){
				Thread.yield();
			}
		}
	}
	
	public static void main(String[] args){
		YieldTest yt1 = new YieldTest("¸ß¼¶");
		yt1.setPriority(MAX_PRIORITY);
		yt1.start();
		YieldTest yt2 = new YieldTest("µÍ¼¶");
		yt2.setPriority(MIN_PRIORITY);
		yt2.start();
		
	}
}
