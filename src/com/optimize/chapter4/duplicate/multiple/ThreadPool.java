package com.optimize.chapter4.duplicate.multiple;

import java.util.List;
import java.util.Vector;


public class ThreadPool {

	private static ThreadPool instance = null;
	
	private List<PThread> idleThreads;
	
	private int threadCounter;
	
	private boolean isShutDown = false;
	
	private ThreadPool() {
		this.idleThreads = new Vector<PThread>(5);
		threadCounter = 0;
	}
	
	public int getCreatedThreadsCount() {
		return threadCounter;
	}
	
	public static synchronized ThreadPool getInstance() {
		if (instance == null) {
			instance = new ThreadPool();
		}
		return instance;
	}
	
	protected synchronized void repool(PThread repoolingThread) {
		if (!isShutDown) {
			idleThreads.add(repoolingThread);
		} else {
			repoolingThread.shutDown();
		}
	}
	
	public synchronized void shutdown() {
		isShutDown = true;
		for (int threadIndex = 0; threadIndex < idleThreads.size(); threadIndex++) {
			PThread idleThread = (PThread)idleThreads.get(threadIndex);
			idleThread.shutDown();
		}
	}
	
	public synchronized void start(Runnable target) {
		PThread thread = null;
		if (idleThreads.size() > 0) {
			int lastIndex = idleThreads.size() - 1;
			thread = idleThreads.get(lastIndex);
			idleThreads.remove(lastIndex);
			thread.setTarget(target);
		} else {
			threadCounter++;
			thread = new PThread(target, "PThread #" + threadCounter, this);
			thread.start();
		}
	}
}
