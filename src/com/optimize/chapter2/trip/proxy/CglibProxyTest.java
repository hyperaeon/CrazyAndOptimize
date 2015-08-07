package com.optimize.chapter2.trip.proxy;

import net.sf.cglib.proxy.Enhancer;

public class CglibProxyTest {

	public static void main(String[] args) {

	}

	public static IDBQuery createCglibProxy() {
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(new CglibDbQueryInterceptor());
		enhancer.setInterfaces(new Class[] { IDBQuery.class });
		IDBQuery cglibProxy = (IDBQuery) enhancer.create();
		return cglibProxy;
	}
}
