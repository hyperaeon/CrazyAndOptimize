package com.runoob.designpattern.decorator;

public class DecoratorPatternDemo {

	public static void main(String[] args) {
		Shape circle = new Circle();
		Shape redCircle = new RedShapeDecorator(new Circle());
		Shape redRectangle = new RedShapeDecorator(new Rectangle());
		System.out.println("Circle with normal border");
		circle.draw();
		
		System.out.println("red Circle with normal border");
		redCircle.draw();
		
		System.out.println("red rectangle with normal border");
		redRectangle.draw();
	}
}
