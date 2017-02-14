package com.designpattern.facade.derail;

public class Fan {

	private boolean isOpen = false;
	
	public void on() {
		System.out.println("电风扇打开");
		isOpen = true;
	}
	
	public void off() {
		System.out.println("电风扇关闭");
		isOpen = false;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	
}
