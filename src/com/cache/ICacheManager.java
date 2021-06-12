package com.cache;

import java.util.Map;
import java.util.Set;

/**
 * @author ly
 * @date 2018年7月25日 下午4:43:33
 */
public interface ICacheManager {

	/**
	 * 放入缓存
	 * @param key
	 * @param cache
	 * ly
	 */
	void putCache(String key, Cache cache);
	
	/**
	 * 放入缓存
	 * @param key
	 * @param data
	 * @param timeOut
	 * ly
	 */
	void putCache(String key, Object data, long timeOut);
	
	/**
	 * 根据key获取缓存
	 * @param key
	 * @return
	 * ly
	 */
	Cache getCacheByKey(String key);
	
	/**
	 * 
	 * @param key
	 * @return
	 * ly
	 */
	Object getDataByKey(String key);
	
	/**
	 * 获取所有缓存
	 * @return
	 * ly
	 */
	Map<String, Cache> getAllCache();
	
	/**
	 * 是否在缓存中存在
	 * @param key
	 * @return
	 * ly
	 */
	boolean isContains(String key);
	
	/**
	 * 清除缓存
	 * 
	 * ly
	 */
	void clearAll();
	
	/**
	 * 清除对应的缓存
	 * @param key
	 * ly
	 */
	void clearByKey(String key);
	
	/**
	 * 是否超时失效
	 * @param key
	 * @return
	 * ly
	 */
	boolean isTimeout(String key);
	
	/**
	 * 获取所有键
	 * @return
	 * ly
	 */
	Set<String> getAllKeys();
}
