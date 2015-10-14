package com.effective.chapter6;

public enum Planet {

	MERCURY(3.302, 2.439),
	VENUS(4.869, 6.052),
	EARTH(5.5975, 6.378),
	MARS(6.419, 3.393),
	JUPITER(1.899, 7.149),
	SATURN(5.685, 6.027),
	URANUS(8.683, 2.556),
	NEPTUNE(10.24, 2.477);
	
	private final double mass;
	
	private final double radius;
	
	private final double surfaceGravity;
	
	private final static double G = 6.67300;
	
	Planet(double mass, double radius) {
		this.mass = mass;
		this.radius = radius;
		surfaceGravity = G * mass / (radius * radius);
	}
	
	public double mass() {
		return mass;
	}
	
	public double radius() {
		return radius;
	}
	
	public double surfaceGravity() {
		return surfaceGravity;
	}
	
	public double surfaceWeight(double mass) {
		return mass * surfaceGravity;
	}
}
