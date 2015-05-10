package com.optimize.chapter3;

import java.util.ArrayList;
import java.util.List;

import com.optimize.chapter2.valueObject.Order;

public class ListRemoveTest {

	public static void main(String[] args) {
		List<Order> list = new ArrayList<>();
		Order order = new Order();
		order.setOrderId(1);
		list.add(order);
		order = new Order();
		order.setOrderId(2);
		list.add(order);
		for (Order od : list) {
			System.out.println(od.getOrderId());
		}
		Order order2 = new Order();
		order2.setOrderId(2);
		if (list.contains(order2)) {
			list.remove(order2);
		}
		for (Order od : list) {
			System.out.println(od.getOrderId());
		}
	}
}
