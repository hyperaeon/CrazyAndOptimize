package com.runoob.designpattern.proxy;

public class RealImage implements Image {

	public String fileName;
	
	public RealImage(String fileName) {
		this.fileName = fileName;
		loadFromDisk(fileName);
	}
	public void loadFromDisk(String fileName) {
		System.out.println("loading..." + fileName);
	}
	
	@Override
	public void display() {
		System.out.println("displaying" + fileName);
	}

}
