package com.designpattern.memento;

public class MementoTest {

	public static void main(String[] args) {
		Original orig = new Original("egg");
		
		Storage store = new Storage(orig.createMemento());
		System.out.println("修改之前的状态：" + orig.getValue());
		orig.setValue("niu");
		System.out.println("修改之后的状态：" + orig.getValue());
		orig.restoreMemento(store.getMemento());
		System.out.println("恢复之后的状态：" + orig.getValue());
		
	}
}
