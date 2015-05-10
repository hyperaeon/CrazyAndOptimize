package com.optimize.chapter4.guardedSuspension.future;

import com.optimize.chapter4.guardedSuspension.Data;

public class Request {

	private String name;

	private Data response;

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

	/**
	 * @return the response
	 */
	public synchronized Data getResponse() {
		return response;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public synchronized void setResponse(Data response) {
		this.response = response;
	}

	public String toString() {
		return "[ Request " + name + " ]";
	}
}
