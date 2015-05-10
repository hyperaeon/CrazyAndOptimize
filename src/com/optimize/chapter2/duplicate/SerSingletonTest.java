package com.optimize.chapter2.duplicate;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;


import static junit.framework.Assert.*;



public class SerSingletonTest {

	@Test
	public void test() throws Exception {
		SerSingleton s1 = null;
		SerSingleton s = SerSingleton.getInstance();
		FileOutputStream fos = new FileOutputStream("SerSingleton.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s);
		oos.flush();
		oos.close();
		
		FileInputStream fis = new FileInputStream("SerSingleton.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		s1 = (SerSingleton) ois.readObject();
		assertEquals(s, s1);
	}
}
