package com.crazy.chapter16.fourth.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer extends Thread {
	private BlockingQueue<String> bq;
	
	public Producer(BlockingQueue<String> bq) {
		this.bq = bq;
	}
	
	public void run() {
		String[] strArr = new String[] {"Java", "Python", "Scala"};
		for (int i = 0; i < 999999999; i++) {
			System.out.println(getName() + "生产者准备生成集合元素");
			try {
				Thread.sleep(200);
				bq.put(strArr[i % 3]);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(getName() + "生成完成：" + bq);
		}
	}
}

class Consumer extends Thread {
	private BlockingQueue<String> bq;
	
	public Consumer(BlockingQueue<String> bq) {
		this.bq = bq;
	}
	
	public void run() {
		while (true) {
			System.out.println(getName() + "消费者消费集合元素");
			try {
				Thread.sleep(200);
				bq.take();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(getName() + "消费完成：" + bq);
			
		}
	}
}

public class BlockingQueueTest {

	public static void main(String[] args) {
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(1);
		new Producer(bq).start();
		new Producer(bq).start();
		new Producer(bq).start();
		new Consumer(bq).start();
	}
}
