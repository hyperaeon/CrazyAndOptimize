package com.crazy.chapter6;

public enum Gender2 {

	MALE("��"),FEMALE("Ů");
	private final String name;
	private Gender2(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
}
