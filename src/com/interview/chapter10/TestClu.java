package com.interview.chapter10;

class Base {
	int i;

	Base() {
		add(1);
		System.out.println(i);
	}

	void add(int v) {
		i += v;
		System.out.println(i);
	}

	void print() {
		System.out.println(i);
	}
}

class MyBase extends Base {
	MyBase() {
		add(2);
	}

	void add(int v) {
		i += v * 2;
		System.out.println(i);
	}
}

public class TestClu {

	public static void main(String[] args) {
		go(new MyBase());
	}

	static void go(Base b) {
		b.add(8);
	}
}
