package com.designpattern.iterator.iter;

public class CollectionTest {

	public static void main(String[] args) {
		Collection collection = new ConcreteCollection();
		Iterator iterator = new ConcreteIterator(collection);
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
