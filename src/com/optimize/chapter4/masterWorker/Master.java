package com.optimize.chapter4.masterWorker;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {

	protected Queue<Object> workQueue = new ConcurrentLinkedQueue<>();

	protected Map<String, Thread> threadMap = new HashMap<>();

	protected Map<String, Object> resultMap = new ConcurrentHashMap<>();

	public boolean isComplete() {
		for (Map.Entry<String, Thread> map : threadMap.entrySet()) {
			if (map.getValue().getState() != Thread.State.TERMINATED) {
				return false;
			}
		}
		return true;
	}

	public Master(Worker worker, int countWorker) {
		worker.setWorkQueue(workQueue);
		worker.setResultMap(resultMap);
		for (int i = 0; i < countWorker; i++) {
			threadMap.put(Integer.toString(i),
					new Thread(worker, Integer.toString(i)));
		}
	}

	public void submit(Object obj) {
		workQueue.add(obj);
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void execute() {
		for (Map.Entry<String, Thread> entry : threadMap.entrySet()) {
			entry.getValue().start();
		}
	}
}
