package com.crazy.chapter15.fourth.serial;

import java.io.Serializable;

public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 598946488123791973L;

	private String name;
	
	private int age;

	private long battleIndex;
	
	public Person() {
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getBattleIndex() {
		return battleIndex;
	}

	public void setBattleIndex(long battleIndex) {
		this.battleIndex = battleIndex;
	}
	

}
