package com.crazy.chapter16.duplicate.synchronize;

public class DrawThread2Test {

	public static void main(String[] args) {
		Account account = new Account("123455", 1000);
		new DrawThread2("����", account, 800).start();
		new DrawThread2("��˼˼", account, 800).start();
	}
}
