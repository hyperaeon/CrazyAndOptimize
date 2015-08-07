package com.crazy.chapter15.duplicate.replace;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.crazy.Constants;

public class ReplaceTest {

	public static void main(String[] args) {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(Constants.basicPath + "replace.txt"));
				ObjectInputStream ois = new ObjectInputStream(
						new FileInputStream(Constants.basicPath + "replace.txt"))) {
			Person p = new Person("sunwukong", 500);
			oos.writeObject(p);
			@SuppressWarnings("unchecked")
			ArrayList<Person> list = (ArrayList<Person>)ois.readObject();
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
