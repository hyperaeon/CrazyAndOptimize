package com.designpattern.facade.derail;

public class Fridge {

	private boolean isOpen = false;
	
	public void on() {
		System.out.println("冰箱打开");
		isOpen = true;
	}
	
	public void off() {
		System.out.println("冰箱关闭");
		isOpen = false;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	
}
