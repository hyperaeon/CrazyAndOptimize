package com.crazy.chapter16.fourth.sync;

public class DrawTest {

	public static void main(String[] args) {
//		Account account = new Account("张三", 1000);
//		new DrawThread("第一次取钱", account, 800).start();
//		new DrawThread("第二次取钱", account, 800).start();
		
		Account account2 = new Account("李四", 1000);
		new SafeDrawThread("第一次取钱", account2, 800).start();
		new SafeDrawThread("第二次取钱", account2, 800).start();
		
	}
}
