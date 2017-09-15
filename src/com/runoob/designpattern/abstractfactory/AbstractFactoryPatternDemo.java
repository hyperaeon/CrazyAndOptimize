package com.runoob.designpattern.abstractfactory;

public class AbstractFactoryPatternDemo {

	public static void main(String[] args) {
		AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
		Shape shape1 = shapeFactory.getShape("CIRCLE");
		shape1.draw();
		
		Shape shape2 = shapeFactory.getShape("RECTANGLE");
		shape2.draw();
		
		AbstractFactory shapeFactory2 = FactoryProducer.getFactory("COLOR");
		Color color1 = shapeFactory2.getColor("RED");
		color1.fill();
	}
}
