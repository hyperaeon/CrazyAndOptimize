package com.crazy.chapter5;

class Root{
	static{
		System.out.println("Root �ľ�̬�����");
	}
	{
		System.out.println("Root ����ͨ�����");
	}
	public Root(){
		System.out.println("Root �Ĺ��캯��");
	}
}
class Mid extends Root{
	static{
		System.out.println("Mid �ľ�̬�����");
	}
	{
		System.out.println("Mid ����ͨ�����");
	}
	public Mid(){
		System.out.println("Mid ���޲ι��캯��");
	}
	public Mid(String str){
		this();
		System.out.println("Mid ���вι��캯��");
	}
}
class Leaf extends Mid{
	static{
		System.out.println("Leaf �ľ�̬�����");
	}
	{
		System.out.println("Leaf ����ͨ�����");
	}
	public Leaf(){
		super("���");
		System.out.println("Leaf ���޲ι��캯��");
	}
	public Leaf(String str){
		this();
		System.out.println("Leaf ���вι��캯��");
	}
}
public class InheritenceTest {
	public static void main(String[] args){
		new Leaf("���");
		new Leaf("���");
	}
	
}
