package com.runoob.designpattern.bridge;

public class GreenCircle implements DrawAPI {

	@Override
	public void drawCircle(int radius, int x, int y) {
		System.out.println("Green circle" + ",radius:" + radius + ",x:" + x + ",y:" +  y);
	}

}
