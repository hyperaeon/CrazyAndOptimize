package com.crazy.chapter8.duplicate.properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesTest {

	private static final String path = "C:\\Users\\hzliyong\\git\\CrazyAndOptimize\\src\\main\\resources\\file\\introduction.xml";
	
	private static final String path2 = "C:\\Users\\hzliyong\\git\\CrazyAndOptimize\\src\\main\\resources\\file\\introduction2.xml";
	
	
	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.setProperty("usename", "yeeku");
		props.setProperty("password", "123456");
//		props.store(new FileOutputStream("chapter8.properties.ini"),
//				"comment line");
		Properties props2 = new Properties();
		props2.setProperty("gender", "male");
//		props2.load(new FileInputStream("chapter8.properties.ini"));
		System.out.println(props2);
		props2.loadFromXML(new FileInputStream(path));
		System.out.println(props2);
		props2.storeToXML(new FileOutputStream(path2), "comment");
	}
}
