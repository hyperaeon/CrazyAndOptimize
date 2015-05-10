package com.crazy.chapter18;

import java.lang.reflect.Proxy;

public class MyProxyFactory {

	public static Object getProxy(Object target) throws Exception {
		MyInvocationHandler handler = new MyInvocationHandler();
		handler.setTarget(target);
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), handler);
	}
}
