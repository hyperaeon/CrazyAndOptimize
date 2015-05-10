package com.crazy.chapter18;

public class Man implements Person {

	@Override
	public void info() {
		System.out.println("我是一个男人");
	}

	@Override
	public void run() {
		System.out.println("一个男人在太空中奔跑");
	}

}
