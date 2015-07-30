package com.designpattern.iterator.duplicate;

public interface Iterator {

	public Object previous();
	
	public boolean hasNext();
	
	public Object next();
	
	public Object first();
}
