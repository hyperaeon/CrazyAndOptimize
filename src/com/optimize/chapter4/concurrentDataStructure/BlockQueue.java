package com.optimize.chapter4.concurrentDataStructure;

import java.util.ArrayList;
import java.util.List;

public class BlockQueue {

	private List<String> list = new ArrayList<>();

	public synchronized Object pop() throws InterruptedException {
		while (list.size() == 0) {
			this.wait();
		}
		if (list.size() > 0) {
			return list.remove(0);
		} else {
			return null;
		}

	}

	public synchronized void put(String str) {
		list.add(str);
		this.notify();
	}
}
