package com.crazy.chapter16.duplicate.comunication;

public class DrawTest {

	public static void main(String[] args) {
		Account account = new Account("123456", 0);
		new DrawThread("取钱者", account, 1000).start();
		new DepositThread("存款者甲", account, 500).start();
		new DepositThread("存款者乙", account, 500).start();

	}
}
