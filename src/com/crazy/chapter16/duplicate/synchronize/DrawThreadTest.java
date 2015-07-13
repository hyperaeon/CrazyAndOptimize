package com.crazy.chapter16.duplicate.synchronize;

public class DrawThreadTest {

	public static void main(String[] args) {
		Account account = new Account("liyong", 30000.00);
		new DrawThread("张三", account, 28000).start();
		new DrawThread("李四", account, 3000).start();
	}
}
