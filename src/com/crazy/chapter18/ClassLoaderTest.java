package com.crazy.chapter18;

class Tester {
	static {
		System.out.println("Tester ��ľ�̬��ʼ��...");
	}
}

public class ClassLoaderTest {

	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		cl.loadClass("com.crazy.chapter18.Tester");
		System.out.println("ϵͳ����Tester��");
		Class.forName("com.crazy.chapter18.Tester");
	}
}
