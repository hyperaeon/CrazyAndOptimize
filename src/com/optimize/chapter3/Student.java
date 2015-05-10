package com.optimize.chapter3;

public class Student implements Comparable<Student> {

	private String name;
	private int score;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	public Student(String name, int s) {
		this.name = name;
		this.score = s;
	}

	@Override
	public int compareTo(Student o) {
		if (o.score < this.score) {
			return 1;
		} else if (o.score > this.score) {
			return -1;
		}
		return 0;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("name:");
		sb.append(name);
		sb.append(" ");
		sb.append("score:");
		sb.append(score);
		return sb.toString();
	}
	
}
