package com.optimize.chapter4.concurrentDataStructure;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

	private static Lock lock = new ReentrantLock();
	private static ReentrantReadWriteLock readWLock = new ReentrantReadWriteLock();
	private static Lock readLock = readWLock.readLock();
	private static Lock writeLock = readWLock.writeLock();

	private static Object value = "abc";

	public Object handleRead() throws InterruptedException {
		try {
			lock.lock();
			Thread.sleep(1);
			return value;
		} finally {
			lock.unlock();
		}
	}
	
	public void handleWrite(int index) throws InterruptedException {
		try {
			lock.lock();
			Thread.sleep(1);
			value = index;
		} finally {
			lock.unlock();
		}
	}
}
