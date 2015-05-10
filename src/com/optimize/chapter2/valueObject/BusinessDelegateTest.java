package com.optimize.chapter2.valueObject;

public class BusinessDelegateTest {

	public static void main(String[] args) throws Exception {
		BusinessDelegate bd = new BusinessDelegate();
		Order order = bd.getOrder(11);
		order.setNumber(11);
		bd.updateOrder(order);
	}
}
