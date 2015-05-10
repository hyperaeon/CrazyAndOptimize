package com.optimize.chapter4.unchange;

public final class Product {

	private final String no;
	private final String name;
	private final double price;
	
	public Product(String no, String name, double price) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
	}

	/**
	 * @return the no
	 */
	public String getNo() {
		return no;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	
	
}
