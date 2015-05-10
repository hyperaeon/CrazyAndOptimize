package com.crazy.chapter16;
class Person{
	public boolean equals(Object o){
		return true;
	}
}

class Dog{
	public boolean equals(Object o){
		return false;
	}
}
public class OverrideEqualsError {

	public static void main(String[] args){
		Person p = new Person();
		Dog d = new Dog();
		System.out.println(p.equals(d));
		System.out.println(d.equals(p));
	}
}
