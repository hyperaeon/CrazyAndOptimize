package com.cache;

import java.util.Map;
import java.util.Set;

/**
 * @author hzliyong
 * @date 2018年7月25日 下午4:43:33
 */
public interface ICacheManager {

	/**
	 * 放入缓存
	 * @param key
	 * @param cache
	 * hzliyong
	 */
	void putCache(String key, Cache cache);
	
	/**
	 * 放入缓存
	 * @param key
	 * @param data
	 * @param timeOut
	 * hzliyong
	 */
	void putCache(String key, Object data, long timeOut);
	
	/**
	 * 根据key获取缓存
	 * @param key
	 * @return
	 * hzliyong
	 */
	Cache getCacheByKey(String key);
	
	/**
	 * 
	 * @param key
	 * @return
	 * hzliyong
	 */
	Object getDataByKey(String key);
	
	/**
	 * 获取所有缓存
	 * @return
	 * hzliyong
	 */
	Map<String, Cache> getAllCache();
	
	/**
	 * 是否在缓存中存在
	 * @param key
	 * @return
	 * hzliyong
	 */
	boolean isContains(String key);
	
	/**
	 * 清除缓存
	 * 
	 * hzliyong
	 */
	void clearAll();
	
	/**
	 * 清除对应的缓存
	 * @param key
	 * hzliyong
	 */
	void clearByKey(String key);
	
	/**
	 * 是否超时失效
	 * @param key
	 * @return
	 * hzliyong
	 */
	boolean isTimeout(String key);
	
	/**
	 * 获取所有键
	 * @return
	 * hzliyong
	 */
	Set<String> getAllKeys();
}
