package com.crazy.chapter6;

public enum Gender3 implements GenderDesc {

	
	
	MALE("��"){
		public void info(){
			System.out.println("���ö�����������");
		}
	};
	private final String name;
	private Gender3(String name){
		this.name = name;
	}
}
