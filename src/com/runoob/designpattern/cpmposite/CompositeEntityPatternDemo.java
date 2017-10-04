package com.runoob.designpattern.cpmposite;

public class CompositeEntityPatternDemo {

	public static void main(String[] args) {
		Client client = new Client();
		client.setData("Test", "Data");
		client.printData();
		
		client.setData("SecondTest", "data1");
		client.printData();
	}
}
