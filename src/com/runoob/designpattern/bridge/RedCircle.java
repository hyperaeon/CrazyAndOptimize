package com.runoob.designpattern.bridge;

public class RedCircle implements DrawAPI {

	@Override
	public void drawCircle(int radius, int x, int y) {
		System.out.println("Red circle" + ",radius:" + radius + ",x:" + x + ",y:" +  y);
	}

}
