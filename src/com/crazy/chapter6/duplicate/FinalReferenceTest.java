package com.crazy.chapter6.duplicate;

import java.util.Arrays;

class Person {
	private int age;

	public Person() {
	}

	public Person(int age) {
		this.age = age;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
}

public class FinalReferenceTest {

	public static void main(String[] args) {
		final int[] iArr = { 5, 6, 12, 9 };
		System.out.println(Arrays.toString(iArr));
		Arrays.sort(iArr);
		System.out.println(Arrays.toString(iArr));
		iArr[2] = 0;
		System.out.println(Arrays.toString(iArr));
		final Person p = new Person(33);
		p.setAge(30);
		System.out.println(p.getAge());
	}
}
