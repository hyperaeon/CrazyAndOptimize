package com.crazy.chapter18.duplicate;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderPropertyTest {

	public static void main(String[] args) throws IOException {
		ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
		System.out.println("system classLoader:" + systemClassLoader);
		
		Enumeration<URL> eml = systemClassLoader.getResources("");
		while (eml.hasMoreElements()) {
			System.out.println(eml.nextElement());
		}
		ClassLoader extensionLoader = systemClassLoader.getParent();
		System.out.println("extension classLoader:" + extensionLoader);
		System.out.println("extension path:" + System.getProperty("java.ext.dirs"));
		System.out.println("extension's parent:" + extensionLoader.getParent());
 	}
}
