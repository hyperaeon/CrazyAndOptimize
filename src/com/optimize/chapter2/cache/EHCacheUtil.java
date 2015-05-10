package com.optimize.chapter2.cache;

import java.io.Serializable;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EHCacheUtil {

	private static CacheManager manager;
	
	private static String configfile = "";
	
	static {
		try {
			manager = CacheManager.create(EHCacheUtil.class.getClassLoader()
					.getResourceAsStream(configfile));
		} catch (CacheException e) {
			e.printStackTrace();
		}
	}
	
	public static void put(String cahceName, Serializable key, Serializable value) {
		manager.getCache(cahceName).put(new Element(key, value));
	}
	
	public static Serializable get(String cacheName, Serializable key) {
		try {
			Element e = manager.getCache(cacheName).get(key);
			if (e == null) {
				return null;
			}
			return e.getValue();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (CacheException e) {
			e.printStackTrace();
		}
		return null;
	}
}
