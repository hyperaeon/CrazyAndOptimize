package com.crazy.chapter5;

class Root{
	static{
		System.out.println("Root 的静态代码块");
	}
	{
		System.out.println("Root 的普通代码块");
	}
	public Root(){
		System.out.println("Root 的构造函数");
	}
}
class Mid extends Root{
	static{
		System.out.println("Mid 的静态代码块");
	}
	{
		System.out.println("Mid 的普通代码块");
	}
	public Mid(){
		System.out.println("Mid 的无参构造函数");
	}
	public Mid(String str){
		this();
		System.out.println("Mid 的有参构造函数");
	}
}
class Leaf extends Mid{
	static{
		System.out.println("Leaf 的静态代码块");
	}
	{
		System.out.println("Leaf 的普通代码块");
	}
	public Leaf(){
		super("你好");
		System.out.println("Leaf 的无参构造函数");
	}
	public Leaf(String str){
		this();
		System.out.println("Leaf 的有参构造函数");
	}
}
public class InheritenceTest {
	public static void main(String[] args){
		new Leaf("你好");
		new Leaf("你好");
	}
	
}
