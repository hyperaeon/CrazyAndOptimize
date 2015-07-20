package com.designpattern.prototype;

import java.io.Serializable;

public class PlainObject implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private String id;

	public PlainObject(String name, String id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Object clone() throws CloneNotSupportedException {
		PlainObject po = (PlainObject) super.clone();
		return po;
	}

}
