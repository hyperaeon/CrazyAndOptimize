package com.optimize.chapter2.duplicate;

import java.lang.reflect.Method;

import javassist.util.proxy.MethodHandler;

public class JavassistDynDbQueryHandler implements MethodHandler {

	IDBQuery real = null;
	
	@Override
	public Object invoke(Object arg0, Method arg1, Method arg2, Object[] arg3)
			throws Throwable {
		if (real == null) {
			real = new DBQuery();
		}
		return real.request();
	}

}
