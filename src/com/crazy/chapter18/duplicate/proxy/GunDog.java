package com.crazy.chapter18.duplicate.proxy;

public class GunDog implements Dog {

	@Override
	public void info() {
		System.out.println("我是一只猎狗");
	}

	@Override
	public void run() {
		System.out.println("我在奔跑");
	}

}
