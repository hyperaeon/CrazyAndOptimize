package com.crazy.chapter15.triple;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TeacherTest {

	public static void main(String[] args) {
		Person student = new Person("wukong", 690);
		Teacher teacher = new Teacher("Laoshi", student);
		System.out.print(teacher.getStudent().getName());
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("object.txt"))) {
			oos.writeObject(teacher);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
