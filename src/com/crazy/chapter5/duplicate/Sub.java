package com.crazy.chapter5.duplicate;

class Base {
	public Base() {
		test();
	}

	public void test() {
		System.out.println("����������д�ķ���");
	}
}

public class Sub extends Base {

	private String name;

	public void test() {
		name = "";
		System.out.println("������д����ķ��� ����name�ַ����ĳ����ǣ�" + name.length());
	}
	
	public static void main(String[] args) {
		Sub s = new Sub();
	}
}
