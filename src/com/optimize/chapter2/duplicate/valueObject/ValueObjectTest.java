package com.optimize.chapter2.duplicate.valueObject;

import java.rmi.Naming;

public class ValueObjectTest {

	public static void main(String[] args) {
		try {
			IOrderManager userManager = (IOrderManager) Naming
					.lookup("OrderManager");
			long begin = System.currentTimeMillis();
			for (int i = 0; i < 1000; i++) {
				userManager.getOrder(i);
			}
			System.out.println("getOrder spend: "
					+ (System.currentTimeMillis() - begin));

			begin = System.currentTimeMillis();
			for (int i = 0; i < 1000; i++) {
				userManager.getClientName(i);
				userManager.getNumber(i);
				userManager.getProdName(i);
			}
			System.out.println("3 method call spend: "
					+ (System.currentTimeMillis() - begin));
			System.out.println(userManager.getOrder(0).getClientName());
		} catch (Exception e) {
			System.out.println("OrderManager Exception : " + e);
		}
	}
}
