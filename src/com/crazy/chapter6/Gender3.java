package com.crazy.chapter6;

public enum Gender3 implements GenderDesc {

	
	
	MALE("男"){
		public void info(){
			System.out.println("这个枚举类代表男性");
		}
	};
	private final String name;
	private Gender3(String name){
		this.name = name;
	}
}
