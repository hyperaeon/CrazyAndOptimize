package com.crazy.chapter5;

public class Person {

	private String name;

	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name.length() > 6 || name.length() < 2){
			System.out.println("���ֳ��Ȳ���");
			return;
		}
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age > 100 || age < 0){
			System.out.println("���䲻��");
			return ;
		}
		this.age = age;
	}

}
