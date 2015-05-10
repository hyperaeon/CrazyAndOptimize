package com.crazy.chapter5;

public class SubSubClass extends SubClass {

	public void test(){
		System.out.println("子类的子类覆盖父类的方法");
		super.getA();
	}
}
