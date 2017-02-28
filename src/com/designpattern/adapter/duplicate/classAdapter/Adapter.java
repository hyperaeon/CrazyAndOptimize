package com.designpattern.adapter.duplicate.classAdapter;

public class Adapter extends Source implements Targetable {

	@Override
	public void method2() {
		System.out.println("method2");
	}

}
