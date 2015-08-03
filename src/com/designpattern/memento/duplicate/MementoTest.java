package com.designpattern.memento.duplicate;

public class MementoTest {

	public static void main(String[] args) {
		Original original = new Original("ori");
		Storage store = new Storage(original.createMemeto());
		System.out.println("Initial state: " + original.getValue());
		original.setValue("changed");
		System.out.println("After changed state: " + original.getValue());
		original.restoreValue(store.getMemento());
		System.out.println("After resotre state: " + original.getValue());
	}
}
