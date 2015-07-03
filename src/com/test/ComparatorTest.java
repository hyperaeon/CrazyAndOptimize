package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

	public static void main(String[] args) {
		final class CustomComparator implements Comparator<Student> {
			
			public CustomComparator() {
				
			}
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getAge() - o2.getAge();
			}
		}
		List<Student> list1 = new ArrayList<Student>();
		Student s1 = new Student(20);
		Student s2 = new Student(60);
		Student s3 = new Student(25);
		list1.add(s1);
		list1.add(s2);
		list1.add(s3);
		
		List<Student> list2 = new ArrayList<Student>();
		Student s4 = new Student(20);
		Student s5 = new Student(60);
		Student s6 = new Student(25);
		list2.add(s4);
		list2.add(s5);
		list2.add(s6);
		CustomComparator c = new CustomComparator();
		Collections.sort(list1, c);
		Collections.sort(list2);
		
		System.out.println(list1);
		System.out.println(list2);
	}
	
}
