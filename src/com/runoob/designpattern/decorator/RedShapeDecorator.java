package com.runoob.designpattern.decorator;

public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}
	
	@Override
	public void draw() {
		shape.draw();
		setRedBorder(shape);
	}
	
	private void setRedBorder(Shape decoratedShape) {
		System.out.println("Border color : Red");
	}

}
