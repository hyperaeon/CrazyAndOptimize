package com.crazy.chapter18;

class Tester {
	static {
		System.out.println("Tester 类的静态初始块...");
	}
}

public class ClassLoaderTest {

	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		cl.loadClass("com.crazy.chapter18.Tester");
		System.out.println("系统加载Tester类");
		Class.forName("com.crazy.chapter18.Tester");
	}
}
