package com.crazy.chapter15.fourth.serial;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadObject {

	private static final String path = "C:\\Users\\hzliyong\\git\\CrazyAndOptimize\\src\\main\\resources\\file\\object.txt";
	
	public static void main(String[] args) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
			Person person = (Person) ois.readObject();
			System.out.println(person.getName() + " " + person.getAge());
		} catch (Exception e) {
			
		}
	}
}
