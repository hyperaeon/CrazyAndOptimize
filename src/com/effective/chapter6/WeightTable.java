package com.effective.chapter6;

public class WeightTable {

	public static void main(String[] args) {
		double earthWeight = Double.parseDouble("2.00");
		double mass = earthWeight / Planet.EARTH.surfaceGravity();
		for (Planet p : Planet.values()) {
			System.out
					.printf("Weight on %s is %f%n", p, p.surfaceWeight(mass));
		}
	}
}
