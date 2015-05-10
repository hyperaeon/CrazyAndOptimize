package com.crazy.chapter18;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderProTest {

	public static void main(String[] args) throws IOException {
		ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
		System.out.println("ϵͳ���������" + systemLoader);
		Enumeration<URL> urls = systemLoader.getResources("");
		while (urls.hasMoreElements()) {
			System.out.println(urls.nextElement());
		}
		ClassLoader extentionLoader = systemLoader.getParent();
		System.out.println("��չ���������" + extentionLoader);
		System.out
				.println("��չ��������ļ���·����" + System.getProperty("java.ext.dirs"));
		System.out.println("��չ���������parent��" + extentionLoader.getParent());
	}
}
