/**
 * 
 */
package com.effective.chapter2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hzliyong
 *
 */
public class Services {

	private Services() {
	}

	private static final Map<String, Provider> providers = new ConcurrentHashMap<String, Provider>();

	public static final String DEFAULT_PROVIDER_NAME = "<def>";

	// Provider registration API
	public static void registerDefaultProvider(Provider p) {
		registerProvider(DEFAULT_PROVIDER_NAME, p);
	}

	public static void registerProvider(String name, Provider p) {
		providers.put(name, p);
	}

	// Service access API
	public static Service newInstance() {
		return newInstance(DEFAULT_PROVIDER_NAME);
	}

	public static Service newInstance(String name) {
		Provider p = providers.get(name);
		if (p == null) {
			throw new IllegalArgumentException("No provider registered with name: " + name);
		}
		return p.newService();
	}

}
