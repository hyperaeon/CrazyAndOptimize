package com.crazy.chapter16;

class MyThread extends Thread{
	
	public MyThread(String name){
		super(name);
	}
	
	public MyThread(ThreadGroup threadGroup,String name){
		super(threadGroup,name);
	}
	public void run(){
		for(int i = 0; i < 100; i ++){
			System.out.println(getName() + "线程的变量i:" + i);
		}
	}
}
public class ThreadGroupTest {

	public static void main(String[] args){
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		System.out.println("mainGroup's name: + " + mainGroup.getName());
		System.out.println("is deamon " + mainGroup.isDaemon());
		new MyThread("主线程组的线程").start();
		ThreadGroup newGroup = new ThreadGroup("新的线程组");
		newGroup.setDaemon(true);
		MyThread mt = new MyThread(newGroup,"新的线程组的线程1");
		mt.start();
		new MyThread(newGroup,"新的线程组的线程2").start();
		
	}
}
