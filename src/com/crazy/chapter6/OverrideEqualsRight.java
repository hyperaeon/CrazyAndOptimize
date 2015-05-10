package com.crazy.chapter6;

class Person{
	private String name;
	
	private String idStr;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdStr() {
		return idStr;
	}

	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}

	public Person(){}
	
	public Person(String name,String idStr){
		this.name = name;
		this.idStr = idStr;
	}
	
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(obj != null && obj.getClass() == Person.class){
			Person person = (Person)obj;
			if(person.getIdStr().equals(this.idStr)){
				return true;
			}
		}
		return false;
	}
}
public class OverrideEqualsRight {

	public  static void main(String[] args){
		Person person1 = new Person("孙行者","123456");
		Person person2 = new Person("者行孙","123456");
		Person person3 = new Person("孙悟饭","654321");
		System.out.println(person1.equals(person2));
		System.out.println(person1.equals(person3));
		System.out.println(person2.equals(person3));
	}
}
