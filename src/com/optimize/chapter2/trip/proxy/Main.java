package com.optimize.chapter2.trip.proxy;

public class Main {

	public static void main(String[] args) {
		IDBQuery query = new DBQueryProxy();
		System.out.println(query.request());
	}
}
