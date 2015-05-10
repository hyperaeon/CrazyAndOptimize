package com.crazy.chapter5;

public class InstanceOfTest {

	public static void main(String[] args){
		Object obj = new Object();
		System.out.println((obj instanceof Object));
		String str = new String();
		System.out.println((str instanceof Object));
//		System.out.println((str instanceof Math));
		Person person = new Person();
		person.setAge(30);
		finalTest(person);
		
	}
	
	public static void finalTest(final Person person){
		person.setAge(10);
		System.out.println(person.getAge());
	}
}
