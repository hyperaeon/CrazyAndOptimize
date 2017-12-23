package com.optimize.chapter4;

import java.util.concurrent.Semaphore;

public class Pool {

	private static final int MAX_AVAILABLE = 100;
	
	private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);
	
	public Object getItem() throws InterruptedException {
		available.acquire();
		return getNextAvailableItem();
	}
	
	protected Object[] items = null;
	
	protected boolean[] used = new boolean[MAX_AVAILABLE];
	
	protected synchronized Object getNextAvailableItem() {
		for (int i = 0; i < MAX_AVAILABLE; ++i) {
			if (!used[i]) {
				used[i] = true;
				return items[i];
			}
		}
		return null;
	}


	public void putItem(Object x) {
		if (markasUnused(x)) {
			available.release();
		}
	}


	protected synchronized boolean markasUnused(Object item) {
		for (int i = 0; i < MAX_AVAILABLE; ++i) {
			if (item == items[i]) {
				if (used[i]) {
					used[i] = false;
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
}
