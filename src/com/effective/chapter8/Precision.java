package com.effective.chapter8;

import java.math.BigDecimal;

public class Precision {

	
	public static void main(String[] args) {
		final BigDecimal TEN_CENTS = new BigDecimal(".10");
		double funds = 1.0;
		int itemsCount = 0;
		for (double price = .10; funds >= price; price += .10) {
			funds -= price;
			itemsCount++;
		}
		System.out.println(itemsCount + " item bought.");
		System.out.println("change:$" + funds);
		
		BigDecimal fund = BigDecimal.valueOf(1.00);
		int count = 0;
		for (BigDecimal prices = TEN_CENTS; fund.compareTo(prices) >= 0; prices = prices.add(TEN_CENTS)) {
			count++;
			fund = fund.subtract(prices);
		}
		System.out.println(count + " item bought.");
		System.out.println("change:$" + fund);
	}
}
