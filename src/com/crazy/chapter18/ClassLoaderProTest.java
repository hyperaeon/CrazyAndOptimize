package com.crazy.chapter18;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderProTest {

	public static void main(String[] args) throws IOException {
		ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
		System.out.println("系统类加载器：" + systemLoader);
		Enumeration<URL> urls = systemLoader.getResources("");
		while (urls.hasMoreElements()) {
			System.out.println(urls.nextElement());
		}
		ClassLoader extentionLoader = systemLoader.getParent();
		System.out.println("扩展类加载器：" + extentionLoader);
		System.out
				.println("扩展类加载器的加载路径：" + System.getProperty("java.ext.dirs"));
		System.out.println("扩展类加载器的parent：" + extentionLoader.getParent());
	}
}
