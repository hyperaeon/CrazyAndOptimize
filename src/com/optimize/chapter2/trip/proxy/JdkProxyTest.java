package com.optimize.chapter2.trip.proxy;

import java.lang.reflect.Proxy;

public class JdkProxyTest {

	public static void main(String[] args) {
		IDBQuery query = createJdkProxy();
		query.request();
	}

	public static IDBQuery createJdkProxy() {
		IDBQuery dbQuery = (IDBQuery) Proxy.newProxyInstance(
				ClassLoader.getSystemClassLoader(),
				new Class[] { IDBQuery.class }, new JdkDbQueryHandler());
		return dbQuery;
	}
}
