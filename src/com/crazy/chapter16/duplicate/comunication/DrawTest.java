package com.crazy.chapter16.duplicate.comunication;

public class DrawTest {

	public static void main(String[] args) {
		Account account = new Account("123456", 0);
		new DrawThread("ȡǮ��", account, 1000).start();
		new DepositThread("����߼�", account, 500).start();
		new DepositThread("�������", account, 500).start();

	}
}
