package com.optimize.chapter3.clone;

import java.util.Vector;

public class Student implements Cloneable {

	private int id;
	private String name;
	private Vector<String> courses;

	public Student() {
		try {
			Thread.sleep(1000);
			System.out.println("Student Constructor called");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the courses
	 */
	public Vector<String> getCourses() {
		return courses;
	}

	/**
	 * @param courses
	 *            the courses to set
	 */
	public void setCourses(Vector<String> courses) {
		this.courses = courses;
	}

	public Student newInstance() {
		try {
			return (Student) this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Student s = (Student) super.clone();
		Vector<String> v = s.getCourses();
		Vector<String> v2 = new Vector<String>();
		for (String str : v) {
			v2.add(str);
		}
		s.setCourses(v2);
		return s;
	}
}
