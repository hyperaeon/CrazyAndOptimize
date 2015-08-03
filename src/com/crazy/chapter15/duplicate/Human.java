package com.crazy.chapter15.duplicate;

import java.io.Serializable;

public class Human implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int arm;

	public int getArm() {
		return arm;
	}

	public void setArm(int arm) {
		this.arm = arm;
	}
	
}
