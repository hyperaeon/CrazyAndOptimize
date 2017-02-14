package com.designpattern.facade.derail;

public class Light {

	private boolean isOpen = false;
	
	public void on() {
		System.out.println("点灯打开");
		isOpen = true;
	}
	
	public void off() {
		System.out.println("点灯关闭");
		isOpen = false;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	
}
