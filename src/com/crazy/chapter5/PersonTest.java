package com.crazy.chapter5;

public class PersonTest {

	public static void main(String[] args) {
		Person p = new Person();
		System.out.println(p.getName());
		p.setAge(120);
		p.setName("sdofwefwsef");
		p.setAge(20);
		p.setName("seo");
		System.out.println(p.getAge() + p.getName());
	}

}
