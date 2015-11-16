package com.crazy.chapter15.triple.resolve;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Orientation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Orientation HORIZONTAL = new Orientation(1);
	public static final Orientation VERTICAL = new Orientation(2);

	private int value;

	private Orientation(int value) {
		this.value = value;
	}

	private Object readResolve() throws ObjectStreamException {
		if (value == 1) {
			return HORIZONTAL;
		} else if (value == 2) {
			return VERTICAL;
		}
		return null;
	}
}
