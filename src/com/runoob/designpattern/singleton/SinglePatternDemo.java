package com.runoob.designpattern.singleton;

public class SinglePatternDemo {

	public static void main(String[] args) {
		SingleObject object = SingleObject.getInstance();
		object.showMessage();
	}
}
