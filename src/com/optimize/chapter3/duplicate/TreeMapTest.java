package com.optimize.chapter3.duplicate;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
		TreeMap<Student, StudentDetailInfo> map = new TreeMap<>();
		Student s1 = new Student("Billy", 70);
		Student s2 = new Student("David", 85);
		Student s3 = new Student("Kite", 92);
		Student s4 = new Student("Cissy", 68);
		map.put(s1, new StudentDetailInfo(s1));
		map.put(s2, new StudentDetailInfo(s2));
		map.put(s3, new StudentDetailInfo(s3));
		map.put(s4, new StudentDetailInfo(s4));
		Map<Student, StudentDetailInfo> map1 = map.subMap(s4, s2);
		for (Iterator<Student> iterator = map1.keySet().iterator(); iterator.hasNext();) {
			Student key = iterator.next();
			System.out.println(key + "->" + map1.get(key));
		}
		System.out.println("subMap end");
		
		map1 = map.headMap(s1);
		for (Iterator<Student> iterator = map1.keySet().iterator(); iterator.hasNext();) {
			Student key = iterator.next();
			System.out.println(key + "->" + map1.get(key));
		}
		System.out.println("headMap end");
		
		map1 = map.tailMap(s1);
		for (Iterator<Student> iterator = map1.keySet().iterator(); iterator.hasNext();) {
			Student key = iterator.next();
			System.out.println(key + "->" + map1.get(key));
		}
		System.out.println("tailMap end");
	}
}
