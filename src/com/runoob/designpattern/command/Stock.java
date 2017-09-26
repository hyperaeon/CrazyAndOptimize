package com.runoob.designpattern.command;

public class Stock {

	private String name = "ABC";
	private int quantity = 10;
	
	public void buy() {
		System.out.println("Stock [name: " + name + ",Quantitiy: " + quantity + "] bought");
	}
	
	public void sell() {
		System.out.println("Stock [name: " + name + ",Quantitiy: " + quantity + "] sold");
	}
	
}
