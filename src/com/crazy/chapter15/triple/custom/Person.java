package com.crazy.chapter15.triple.custom;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.writeObject(new StringBuffer(name).reverse());
		oos.writeInt(age);
	}
	
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		this.name = ((StringBuffer)ois.readObject()).reverse().toString();
		this.age = ois.readInt();
	}

}
