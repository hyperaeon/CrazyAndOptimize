package com.interview.chapter10;

class Father {
	public static String getName() {
		return "Father";
	}
}

class Child extends Father {
	public static String getName() {
		return "Child";
	}
}

public class MorphoyTest {

	public static void main(String[] args) {
		Father father = new Father();
		Father child = new Child();
		if (child instanceof Child) {
			System.out.println("Child");
		}
		System.out.println(father.getName());
		System.out.println(child.getName());

	}

}
