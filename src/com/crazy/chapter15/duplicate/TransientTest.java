package com.crazy.chapter15.duplicate;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientTest {

	public static void main(String[] args) {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(Constants.basicPath + "transient.txt"));
				ObjectInputStream ois = new ObjectInputStream(
						new FileInputStream(Constants.basicPath
								+ "transient.txt"))) {
			Person p = new Person("sun", 500);
			oos.writeObject(p);
			Person p1 = (Person) ois.readObject();
			System.out.println(p1.getAge());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
