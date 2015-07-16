package com.designpattern.chainOfResponsibility;

public class HandlerTest {

	public static void main(String[] args) {
		MyHandler handler1 = new MyHandler("h1");
		MyHandler handler2 = new MyHandler("h2");
		MyHandler handler3 = new MyHandler("h3");
		handler1.setHandler(handler2);
		handler2.setHandler(handler3);
		handler1.operation();
	}
}
