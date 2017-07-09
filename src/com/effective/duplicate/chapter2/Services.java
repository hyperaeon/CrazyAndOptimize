package com.effective.duplicate.chapter2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Services {

	private Services() {}
	
	private static final Map<String, Provider> providers = new ConcurrentHashMap<String, Provider>();
	
	private static final String DEFAULT_PROVIDER_NAME = "<def>";
	
	public static void registerDefaultProvider(Provider p) {
		registerProvider(DEFAULT_PROVIDER_NAME, p);
	}
	
	public static void registerProvider(String name, Provider p) {
		providers.put(name, p);
	}
	
	public static Service newInstance() {
		return newInstance(DEFAULT_PROVIDER_NAME);
	}
	
	public static Service newInstance(String name) {
		Provider p = providers.get(name);
		if (p == null) {
			throw new IllegalArgumentException("No provider register with name:" + name);
		}
		return p.newService();
	}
}
