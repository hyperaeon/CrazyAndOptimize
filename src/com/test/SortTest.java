package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {
	private Integer age;
	public Student(int age) {
		this.age = age;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public int compareTo(Student s) {
		return this.age.compareTo(s.age); 
	}
	
	public String toString() {
		return "Student [age: " + age + "]";
	}
}
public class SortTest {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		Student s1 = new Student(20);
		Student s2 = new Student(33);
		Student s3 = new Student(29);
		list.add(s1);
		list.add(s2);
		list.add(s3);
		Collections.sort(list);
		System.out.println(list);
	}
	
}
