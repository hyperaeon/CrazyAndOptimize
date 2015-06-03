package com.crazy.chapter5;

public class SubClass extends BaseClass {

	public String book = "java";
	
	public void test(){
		System.out.println("子类的覆盖父类的方法");
		super.getA();
	}
	
	public void sub(){
		System.out.println("子类的普通方法");
	}
	
	public static void main(String[] args){
		BaseClass bc = new BaseClass();
		bc.base();
		bc.test();
		SubClass sc = new SubClass();
		sc.base();
		sc.test();
		
		BaseClass poly = new SubClass();
		System.out.println(poly.book);
		poly.base();
		poly.test();
		
		SubClass ss = (SubClass)poly;
		System.out.println(ss.book);
		ss.base();
		ss.test();
	}
}
