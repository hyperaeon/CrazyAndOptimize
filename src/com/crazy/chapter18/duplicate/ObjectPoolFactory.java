package com.crazy.chapter18.duplicate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ObjectPoolFactory {

	private Map<String, Object> objectPool = new HashMap<>();
	
	private Object createObject(String clazzName) throws InstantiationException, 
		IllegalAccessException, ClassNotFoundException {
		Class<?> clazz = Class.forName(clazzName);
		return clazz.newInstance();
	}
	
	public void initPool(String fileName) throws InstantiationException,
		IllegalAccessException, ClassNotFoundException {
		try (FileInputStream fis = new FileInputStream(fileName)) {
			Properties props = new Properties();
			props.load(fis);
			for (String name : props.stringPropertyNames()) {
				objectPool.put(name, createObject(props.getProperty(name)));
			}
		} catch (IOException e) {
			System.out.println("读取" + fileName + "异常");
		}
	}
	

	public Object getObject(String name) {
		return objectPool.get(name);
	}
	
	public static void main(String[] args) throws Exception {
		ObjectPoolFactory pf = new ObjectPoolFactory();
		pf.initPool("obj.txt");
		System.out.println(pf.getObject("a"));
		System.out.println(pf.getObject("b"));
	}
}
