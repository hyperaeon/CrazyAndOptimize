package com.runoob.designpattern.builder;

public class VegBurger extends Burger {

	@Override
	public String name() {
		return "Veg Burge";
	}

	@Override
	public float price() {
		return 25.0f;
	}

}
