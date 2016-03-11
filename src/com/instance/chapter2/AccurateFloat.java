package com.instance.chapter2;

import java.math.BigDecimal;

public class AccurateFloat {

	public static void main(String[] args) {
		double price = 2;
		double remain = 1.1;
		double cost = price - remain;
		System.out.println("Cost money: " + cost);
		BigDecimal money1 = new BigDecimal("2");
		BigDecimal money2 = new BigDecimal("1.1");
		BigDecimal money3 = money1.subtract(money2);
		System.out.println("accurate money: " + money3);
				
	}
}
