package com.designpattern.adapter;

public class AdapterTest2 {

	public static void main(String[] args) {
		Source source = new Source();
		Targetable target = new Wrapper(source);
		target.method1();
		target.method2();
	}
}
