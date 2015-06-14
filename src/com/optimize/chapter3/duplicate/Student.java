package com.optimize.chapter3.duplicate;

public class Student implements Comparable<Student>{

	private String name;
	private int score;
	
	@Override
	public int compareTo(Student o) {
		if (this.score < o.score) {
			return -1;
		} else if (this.score > o.score) {
			return 1;
		}
		return 0;
	}

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("name:");
		sb.append(name);
		sb.append(" ");
		sb.append("score:");
		sb.append(score);
		return sb.toString();
	}

}
