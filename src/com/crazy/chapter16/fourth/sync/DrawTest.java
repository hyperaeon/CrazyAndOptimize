package com.crazy.chapter16.fourth.sync;

public class DrawTest {

	public static void main(String[] args) {
//		Account account = new Account("����", 1000);
//		new DrawThread("��һ��ȡǮ", account, 800).start();
//		new DrawThread("�ڶ���ȡǮ", account, 800).start();
		
		Account account2 = new Account("����", 1000);
		new SafeDrawThread("��һ��ȡǮ", account2, 800).start();
		new SafeDrawThread("�ڶ���ȡǮ", account2, 800).start();
		
	}
}
