package com.crazy.chapter18;

public class Woman implements Person {

	@Override
	public void info() {
		System.out.println("我是一个女人");
	}

	@Override
	public void run() {
		System.out.println("一个女人在海底游泳");
	}

}
