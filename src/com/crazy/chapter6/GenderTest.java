package com.crazy.chapter6;

public class GenderTest {

	public static void main(String[] args){
		Gender g = Enum.valueOf(Gender.class,"FEMALE");
		g.setName("Ů");
		System.out.println(g + "����" + g.getName());
		g.setName("��");
		System.out.println(g + "����" + g.getName());
		
	}
}
