package com.designpattern.iterator.iter;

public class ConcreteCollection implements Collection {

	public String string[] = {"A", "B", "C", "D", "E"};
	
	@Override
	public Iterator iterator() {
		return new ConcreteIterator(this);
	}

	@Override
	public Object get(int index) {
		return string[index];
	}

	@Override
	public int size() {
		return string.length;
	}

}
