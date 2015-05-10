package com.optimize.chapter3;

public class StudentDetailInfo {

	Student s;

	public StudentDetailInfo(Student s) {
		this.s = s;
	}

	public String toString() {
		return s.getName() + "'s detail information";
	}
}
