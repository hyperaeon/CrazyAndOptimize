package com.designpattern.prototype.duplicate;

public class Prototype implements Cloneable {

	public Object clone() throws CloneNotSupportedException {
		Prototype pro = (Prototype) super.clone();
		return pro;
	}
}
