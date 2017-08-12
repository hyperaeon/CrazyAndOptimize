package com.crazy.chapter15.fourth.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ReplaceTest {
	
	private static final String path = "C:\\Users\\hzliyong\\git\\CrazyAndOptimize\\src\\main\\resources\\file\\replace.txt";
	
	public static void main(String[] args) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));) {
			Person2 person2 = new Person2("唐僧", 30);
			oos.writeObject(person2);
			List<Object> list = (ArrayList<Object>) ois.readObject();
			System.out.println(list.get(0));
			System.out.println(list.get(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
