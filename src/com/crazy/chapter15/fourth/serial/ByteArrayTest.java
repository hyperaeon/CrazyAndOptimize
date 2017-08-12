package com.crazy.chapter15.fourth.serial;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ByteArrayTest {

	public static void main(String[] args) {
		Person person = new Person("zhangsan", 332);
		try (ByteArrayOutputStream os = new ByteArrayOutputStream();
				ObjectOutputStream out = new ObjectOutputStream(os);) {
			out.writeObject(person);
			byte[] zhangsan = os.toByteArray();
			ByteArrayInputStream is = new ByteArrayInputStream(zhangsan);
			ObjectInputStream in = new ObjectInputStream(is);
			Person p = (Person) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
