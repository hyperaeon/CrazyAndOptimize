package com.optimize.chapter2;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibDbQueryInterceptor implements MethodInterceptor {

	IDBQuery real = null;
	
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		if (real == null) {
			real = new DBQuery();
		}
		return real.request();
	}

}
