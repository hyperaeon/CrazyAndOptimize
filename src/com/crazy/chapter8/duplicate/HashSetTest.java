package com.crazy.chapter8.duplicate;

import java.util.HashSet;

class A {
	public boolean equals(Object obj) {
		return true;
	}
}

class B {
	public int hashCode() {
		return 1;
	}
}

class C {
	public boolean equals(Object obj) {
		return true;
	}
	
	public int hashCode() {
		return 2;
	}
}

public class HashSetTest {

	public static void main(String[] args) {
		HashSet<Object> books = new HashSet<>();
		books.add(new A());
		books.add(new A());
		books.add(new B());
		books.add(new B());
		books.add(new C());
		books.add(new C());
		System.out.println(books);
		
	}
}
