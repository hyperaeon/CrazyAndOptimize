package com.crazy.chapter16.duplicate.synchronize;

public class DrawThread3Test {

	public static void main(String[] args) {
		AccountSafe account = new AccountSafe("123456", 1000);
		new DrawThread3("张三丰", account, 900).start();
		new DrawThread3("李思怡", account, 900).start();
	}
}
