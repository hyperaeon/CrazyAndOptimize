package com.crazy.chapter8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args)throws Exception{
		Properties prop = new Properties();
		prop.put("userName", "Oliver");
		prop.put("password", "123");
		prop.store(new FileOutputStream("a.ini"), "comment line");
		Properties prop2 = new Properties();
		prop2.setProperty("gender", "male");
		prop2.load(new FileInputStream("a.ini"));
		System.out.println(prop2);
	}
}
