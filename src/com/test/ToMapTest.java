package com.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ToMapTest {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		Person p1 = new Person();
		p1.setName("野火");
		p1.setAddress("中国");
		Person p2 = new Person();
		p2.setName("野火");
		p2.setAddress("美国");
		Person p3 = new Person();
		p3.setName("野火");
		p3.setAddress("印尼");
		people.add(p1);
		people.add(p2);
		people.add(p3);
		Map<String, String> phoneBook =
				people.stream().collect(Collectors.toMap(Person :: getName, Person :: getAddress));
		System.out.println(phoneBook.size());
	}
}

class Person implements Serializable {
	private String name;
	
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
