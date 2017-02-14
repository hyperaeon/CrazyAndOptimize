package com.designpattern.iterator.iter;


public class ConcreteIterator implements Iterator {

	private Collection collection;

	private int key;
	
	public ConcreteIterator(Collection collection) {
		this.collection = collection;
		key = -1;
	}
	
	@Override
	public boolean hasNext() {
		if (key < collection.size() - 1) {
			return true;
		}
		return false;
	}

	@Override
	public Object next() {
		if (key < collection.size() - 1) {
			key ++;
		}
		return collection.get(key);
	}

	@Override
	public Object previous() {
		if (key > 0) {
			key --;
		}
		return collection.get(key);
	}

	@Override
	public Object first() {
		if (collection.size() > 0) {
			return collection.get(0);
		}
		return null;
	}


}
