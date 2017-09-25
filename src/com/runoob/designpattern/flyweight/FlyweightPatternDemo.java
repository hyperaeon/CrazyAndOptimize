package com.runoob.designpattern.flyweight;

import java.util.Random;

public class FlyweightPatternDemo {

	private static final String colors[] = {"Red", "Green", "Blue", "White", "Black"};
	
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			Circle circle = (Circle)ShapeFactory.getCircle(getRandomColor());
			circle.setX(getRandomX());
			circle.setY(getRandomY());
			circle.setRadius(100);
			circle.draw();
		}
	}
	
	private static String getRandomColor() {
		int r = getRandom(colors.length);
		return colors[r];
	}
	
	private static int getRandomX() {
		return getRandom(100);
	}
	
	private static int getRandomY() {
		return getRandom(100);
	}
	
	private static int getRandom(int seed) {
		Random random = new Random();
		return random.nextInt(seed);
	}
}
