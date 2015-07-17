package com.designpattern.adapter.classAdapter;

public class AdapterTest {

	public static void main(String[] args) {
		Targetable adapter = new Adapter();
		adapter.method1();
		adapter.method2();
	}
}
