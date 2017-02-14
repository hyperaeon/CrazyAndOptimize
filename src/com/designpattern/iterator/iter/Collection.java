package com.designpattern.iterator.iter;

public interface Collection {

	public Iterator iterator();
	
	public Object get(int index);
	
	public int size(); 
}
