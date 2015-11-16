package com.crazy.chapter15.triple;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientTest {

	public static void main(String[] args) {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(Constants.currentPath + "transient.txt"));
				ObjectInputStream ois = new ObjectInputStream(
						new FileInputStream(Constants.currentPath
								+ "transient.txt"))) {
			TransientPerson transientPerson = new TransientPerson("wukong", 490);
			oos.writeObject(transientPerson);
			TransientPerson wukong = (TransientPerson) ois.readObject();
			System.out.println(wukong.getName() + " " + wukong.getAge());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
