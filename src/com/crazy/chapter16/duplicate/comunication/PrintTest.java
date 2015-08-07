package com.crazy.chapter16.duplicate.comunication;

public class PrintTest {

	public static void main(String[] args) {
		Swap swap = new Swap();
		new PrintAThread("线程A ", swap).start();
		new PrintBThread("线程B ", swap).start();
	}
}
