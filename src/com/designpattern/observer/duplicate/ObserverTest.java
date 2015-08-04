package com.designpattern.observer.duplicate;

public class ObserverTest {

	public static void main(String[] args) {
		Observer1 o1 = new Observer1();
		Observer1 o2 = new Observer1();
		Subject m = new MySubject();
		m.add(o1);
		m.add(o2);
		m.operation();
	}
}
