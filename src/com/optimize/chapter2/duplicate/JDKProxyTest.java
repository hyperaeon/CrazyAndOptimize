package com.optimize.chapter2.duplicate;

import java.lang.reflect.Proxy;


public class JDKProxyTest {

	public static IDBQuery createJdkProxy() {
		IDBQuery jdkProxy = (IDBQuery) Proxy.newProxyInstance(
				ClassLoader.getSystemClassLoader(),
				new Class[] { IDBQuery.class },  new JdkDbQueryHandler());
		return jdkProxy;
	}
}
