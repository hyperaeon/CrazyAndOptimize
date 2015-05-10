package com.crazy.chapter16;

public class DrawTest {

	public static void main(String[] args) {
		Accounts a1 = new Accounts("001", 300);
		new DrawThread("第一个线程", a1, 200).start();
		new DrawThread("第二个线程", a1, 100).start();
	}
}
