package com.designpattern.adapter.interfaceAdapter;

public class AdapterTest {

	public static void main(String[] args) {
		SouceSub1 sub1 = new SouceSub1();
		SouceSub2 sub2 = new SouceSub2();
		sub1.method1();
		sub1.method2();

		sub2.method1();
		sub2.method2();
	}
}
