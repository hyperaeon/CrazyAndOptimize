package com.crazy.chapter5;

class Block{
	static{
		System.out.println("��̬�����");
	}
	{
		System.out.println("�Ǿ�̬�����");
	}
}
public class StaticBlock {

	public static void main(String[] args){
		Block block = new Block();
		Block block2 = new Block();
	}
}
