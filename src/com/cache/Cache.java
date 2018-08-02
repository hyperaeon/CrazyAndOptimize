package com.cache;

/**
 * @author hzliyong
 * @date 2018年7月24日 上午9:23:00
 */
public class Cache {

	private Object data;
	
	private long timeOut;
	
	private long lastRefreshTime;

	public Cache() {}
	
	public Cache(Object data, long timeOut, long lastRefreshTime) {
		this.data = data;
		this.timeOut = timeOut;
		this.lastRefreshTime = lastRefreshTime;
	}
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public long getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(long timeOut) {
		this.timeOut = timeOut;
	}

	public long getLastRefreshTime() {
		return lastRefreshTime;
	}

	public void setLastRefreshTime(long lastRefreshTime) {
		this.lastRefreshTime = lastRefreshTime;
	}
	
}
