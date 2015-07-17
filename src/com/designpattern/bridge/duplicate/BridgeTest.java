package com.designpattern.bridge.duplicate;

public class BridgeTest {

	public static void main(String[] args) {
		Bridge bridge = new MyBridge();
		
		SoureSub1 sub1 = new SoureSub1();
		bridge.setSource(sub1);
		bridge.method();
		
		SoureSub2 sub2 = new SoureSub2();
		bridge.setSource(sub2);
		bridge.method();
		
	}
}
