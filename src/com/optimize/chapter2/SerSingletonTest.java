package com.optimize.chapter2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerSingletonTest {

	public static void main(String[] args) throws Exception {
		SerSingleton s1 = null;
		
		SerSingleton s = SerSingleton.getInstance();
		FileOutputStream fos = new FileOutputStream("SerSingleton.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s);
		oos.flush();
		oos.close();
		
		FileInputStream fis = new FileInputStream("SerSingleton.txt") ;
		ObjectInputStream ois = new ObjectInputStream(fis);
		s1 = (SerSingleton) ois.readObject();
		ois.close();
		System.out.println("s == s1 ? " + (s == s1));
	}
	
}
