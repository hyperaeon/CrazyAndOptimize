package com.crazy.chapter6;

import java.util.Arrays;

class Persons{
	private int age;
	
	public Persons(int age){
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
public class FinalReferenceTest {

	public static void main(String[] args){
		final int[] arr = {3,43,23,98,43};
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		arr[3] = 89;
		System.out.println(Arrays.toString(arr));
		Persons p = new Persons(39);
		System.out.println(p.getAge());
		p.setAge(99);
		System.out.println(p.getAge());
	}
}
