package com.crazy.chapter15.fourth.serial;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TeacherTest {

	public static void main(String[] args) {
		Person person = new Person("孙悟空", 500);
		person.setBattleIndex(10000L);
		Teacher teacher = new Teacher("菩提", person);
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(bos);) {
			oos.writeObject(teacher);
			byte[] tByte = bos.toByteArray();
			ByteArrayInputStream bis = new ByteArrayInputStream(tByte);
			ObjectInputStream ois = new ObjectInputStream(bis);
			Teacher t = (Teacher) ois.readObject();
			System.out.println(t.getName());
			System.out.println(t.getStudent());
			System.out.println(t.getStudent().getBattleIndex());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
