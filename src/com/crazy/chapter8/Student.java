package com.crazy.chapter8;

public class Student {

	private int sid;
	private String sname;
	private int age;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sid;
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if(obj == null){
			return false;
		}
		if(getClass() != obj.getClass()){
			return false;
		}
		Student student = (Student)obj;
		if(sid != student.sid){
			return false;
		}
		if(sname == null){
			if(student.sname != null){
				return false;
			}
		}else if(!sname.equals(student.sname)){
			return false;
		}
		return true;
	}
	
	
}
