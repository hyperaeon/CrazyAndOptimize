package com.designpattern.iterator.duplicate;

public class MyCollection implements Collection {

	private String[] str = { "A", "B", "C", "D", "E" };

	@Override
	public Iterator iterator() {
		return new MyIterator(this);
	}

	@Override
	public Object get(int index) {
		return str[index];
	}

	@Override
	public int size() {
		return str.length;
	}

}
