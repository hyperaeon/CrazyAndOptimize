package com.crazy.chapter4;

public class ReferenceArrayTest {

	public static void main(String[] args) {
		Person[] persons;
		persons = new Person[2];

		Person zhang = new Person();
		zhang.age = 12;
		zhang.height = 1.9;

		Person lee = new Person();
		lee.age = 29;
		lee.height = 1.7;

		persons[0] = zhang;
		persons[1] = lee;

		lee.info();
		persons[1].info();

	}
}
