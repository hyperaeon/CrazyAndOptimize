package com.crazy.chapter16;

public class DrawTest {

	public static void main(String[] args) {
		Accounts a1 = new Accounts("001", 300);
		new DrawThread("��һ���߳�", a1, 200).start();
		new DrawThread("�ڶ����߳�", a1, 100).start();
	}
}
