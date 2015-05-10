package com.crazy.chapter5;

class Block{
	static{
		System.out.println("¾²Ì¬´úÂë¿é");
	}
	{
		System.out.println("·Ç¾²Ì¬´úÂë¿é");
	}
}
public class StaticBlock {

	public static void main(String[] args){
		Block block = new Block();
		Block block2 = new Block();
	}
}
