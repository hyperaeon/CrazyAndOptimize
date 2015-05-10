package com.crazy.chapter8;

import java.util.HashSet;

public class HashSetTest {

	public static void main(String[] args) {
		HashSet books = new HashSet();
		books.add(new A());
		books.add(new A());
		books.add(new B());
		books.add(new B());
		books.add(new C());
		books.add(new C());
		System.out.println(books);
		
		B b1 = new B();
		B b2 = new B();
		System.out.println(b1.equals(b2));
	}

}
class A{
	public boolean equals(Object obj){
		return true;
	}
}
class B{
	
	public int hashCode(){
		return 1;
	}
}
class C{
	public int hashCode(){
		return 2;
	}
	public boolean equals(Object obj){
		return true;
	}
}