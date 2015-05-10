package com.optimize.chapter4.guardedSuspension;

public class Request {

	private String name;

	public Request(String name) {
		this.name = name;
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

	public String toString() {
		return "[ Request " + name + " ]";
	}
}
