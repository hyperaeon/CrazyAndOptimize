package com.designpattern.iterator;

public class CollectionTest {

	public static void main(String[] args) {
		Collection collection = new MyCollection();
		Iterator iterator = collection.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
