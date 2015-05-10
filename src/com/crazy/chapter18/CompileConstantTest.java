package com.crazy.chapter18;

class MyTest {
	static {
		System.out.println("¾²Ì¬³õÊ¼»¯¿é...");
	}
	static final String compileConstant = "Java";
	static final String compileNotConstant = System.currentTimeMillis() + "Java";
}

public class CompileConstantTest {

	public static void main(String[] args) {
		System.out.println(MyTest.compileConstant);
		System.out.println(MyTest.compileNotConstant);
	}
}
