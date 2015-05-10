package com.crazy.chapter18;

import java.lang.reflect.Proxy;

public class MyProxyFactorys {

	public static Object getProxy(Object target) throws Exception {
		MyInvocationHandlers handler = new MyInvocationHandlers();
		handler.setTarget(target);
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), handler);
	}
}
