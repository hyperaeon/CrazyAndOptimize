package com.crazy.chapter15.triple.replace;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.crazy.chapter15.triple.Constants;

public class ReplaceTest {

	public static void main(String[] args) {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(Constants.currentPath + "replace.txt"));
				ObjectInputStream ois = new ObjectInputStream(
						new FileInputStream(Constants.currentPath
								+ "replace.txt"))) {
			Person person = new Person("wukong", 5000);
			oos.writeObject(person);

			ArrayList<Object> list = (ArrayList<Object>) ois.readObject();
			System.out.println((String)list.get(0) + list.get(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
