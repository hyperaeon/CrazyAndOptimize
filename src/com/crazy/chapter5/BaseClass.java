package com.crazy.chapter5;

public class BaseClass {

	private int a = 3;
	public int book = 6;
	public void base(){
		System.out.println("父类的普通方法");
	}
	public void test(){
		System.out.println("父类的被覆盖方法");
	}
	/**
	 * @return the a
	 */
	public int getA() {
		return a;
	}
	/**
	 * @param a the a to set
	 */
	public void setA(int a) {
		this.a = a;
	}
	
	
}
