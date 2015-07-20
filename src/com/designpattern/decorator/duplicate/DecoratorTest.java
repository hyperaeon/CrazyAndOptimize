package com.designpattern.decorator.duplicate;

public class DecoratorTest {

	public static void main(String[] args) {
		Source source = new Source();
		Decorator decorator = new Decorator(source);
		decorator.method();
	}
}
