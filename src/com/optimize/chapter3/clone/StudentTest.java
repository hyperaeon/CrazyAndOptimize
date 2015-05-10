package com.optimize.chapter3.clone;

import java.util.Vector;

public class StudentTest {

	public static void main(String[] args) {
		Student s1 = new Student();
		Vector<String> cs = new Vector<>();
		cs.add("Java");
		s1.setId(1);
		s1.setName("Liyong");
		s1.setCourses(cs);
		
		Student s2 = s1.newInstance();
		s2.setId(2);
		s2.setName("Liming");
		s2.setCourses(cs);
		
		System.out.println("s1'name " + s1.getName());
		System.out.println("s2'name " + s2.getName());
		System.out.println(s1.getCourses() == s2.getCourses());
		
	}
}
