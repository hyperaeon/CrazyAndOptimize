package com.crazy.chapter7;

class Address implements Cloneable {
	String detail;

	public Address(String detail) {
		this.detail = detail;
	}
	public Address clone() throws CloneNotSupportedException {
		return (Address) super.clone();
	}
}

class User implements Cloneable {
	int age;
	Address address;

	public User(int age) {
		address = new Address("ÖÐ¹úº¼ÖÝ");
	}

	public User clone() throws CloneNotSupportedException {
		User user = (User) super.clone();
		user.address = address.clone();
		return user;
	}

}

public class CloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		User user1 = new User(30);
		User user2 = user1.clone();
		System.out.println("user1 == user2 ? " + (user1 == user2));
		System.out.println("user1.address == user2.address ? "
				+ (user1.address == user2.address));
	}
}
