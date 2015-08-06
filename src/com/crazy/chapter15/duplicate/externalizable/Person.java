package com.crazy.chapter15.duplicate.externalizable;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
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

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(new StringBuffer(name).reverse());
		out.writeInt(age);
		;
	}

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		this.name = ((StringBuffer) in.readObject()).reverse().toString();
		this.age = in.readInt();
	}
}
