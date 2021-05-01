package com.cache;

/**
 * @author ly
 * @date 2018年7月30日 上午10:33:24
 */
public class CacheTest {

	public static void main(String[] args) {
		CacheManagerImpl cacheManagerImpl = new CacheManagerImpl();
		cacheManagerImpl.putCache("test", "test", 10 * 1000L);
		cacheManagerImpl.putCache("myTest", "myTest", 10 * 1000L);
		CacheListener cacheListener = new CacheListener(cacheManagerImpl);
		cacheListener.startListen();
		System.out.println(cacheManagerImpl.getCacheByKey("test").getData());
		System.out.println(cacheManagerImpl.getCacheByKey("myTest").getData());
		try {
			Thread.sleep(2000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(cacheManagerImpl.getCacheByKey("test"));
		System.out.println(cacheManagerImpl.getCacheByKey("myTest"));
	}
}
