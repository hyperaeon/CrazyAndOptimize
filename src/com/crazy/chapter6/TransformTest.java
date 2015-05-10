package com.crazy.chapter6;

public class TransformTest {

	public void transform(Object value) {
		if (value == null) {
			System.out.println("null");
		}
		try {
			Double cost = (Double)value;
		} catch (Exception e) {
			System.out.println("Number illegal");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Object value = "3.33.";
		new TransformTest().transform(value);
	}
}
