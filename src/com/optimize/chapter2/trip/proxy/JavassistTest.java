package com.optimize.chapter2.trip.proxy;

import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

public class JavassistTest {

	public static IDBQuery createJavassistDynProxy() throws Exception {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setInterfaces(new Class[] { IDBQuery.class });
		Class proxyClass = proxyFactory.createClass();
		IDBQuery javassistProxy = (IDBQuery) proxyClass.newInstance();
		((ProxyObject) javassistProxy)
				.setHandler(new JavassistDynDbQueryHandler());
		return javassistProxy;
	}
}
