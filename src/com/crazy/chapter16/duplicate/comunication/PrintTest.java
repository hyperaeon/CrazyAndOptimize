package com.crazy.chapter16.duplicate.comunication;

public class PrintTest {

	public static void main(String[] args) {
		Swap swap = new Swap();
		new PrintAThread("�߳�A ", swap).start();
		new PrintBThread("�߳�B ", swap).start();
	}
}
