package com.designpattern.proxy.instance;

import java.lang.reflect.Method;

public class GenericProxyWeather {

	protected Weather subject;
	
	public GenericProxyWeather(Weather subject) {
		this.subject = subject;
	}
	
	public void call(String method, String args) throws Exception {
		Class clazz = Weather.class;
		Method m = clazz.getDeclaredMethod(method, String.class);
		m.invoke(clazz, args);
	}
}
