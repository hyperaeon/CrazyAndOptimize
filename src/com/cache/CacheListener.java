package com.cache;

/**
 * @author ly
 * @date 2018年7月30日 上午10:24:21
 */
public class CacheListener {

	private CacheManagerImpl cacheManagerImpl;
	
	public CacheListener(CacheManagerImpl cacheManagerImpl) {
		this.cacheManagerImpl = cacheManagerImpl;
	}
	
	public void startListen() {
		new Thread() {
			public void run() {
				while (true) {
					for (String key : cacheManagerImpl.getAllKeys()) {
						if (cacheManagerImpl.isTimeout(key)) {
							cacheManagerImpl.clearByKey(key);
						}
					}
				}
			}
		}.start();
	}
}
