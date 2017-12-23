package com.optimize.chapter4;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLockCar extends Thread {
	
	protected Object myDirect;
	
	static ReentrantLock south = new ReentrantLock();
	
	static ReentrantLock north = new ReentrantLock();
	
	static ReentrantLock west = new ReentrantLock();
	
	static ReentrantLock east = new ReentrantLock();
	
	public DeadLockCar(Object obj) {
		this.myDirect = obj;
		if (myDirect == south) {
			this.setName("south");
		}
		if (myDirect == north) {
			this.setName("north");
		}
		if (myDirect == west) {
			this.setName("west");
		}
		if (myDirect == east) {
			this.setName("east");
		}
	}
	
	@Override
	public void run() {
		if (myDirect == south) {
			execution("sorth", west, south);
		}
		if (myDirect == north) {
			execution("north", east, north);
		}
		if (myDirect == west) {
			execution("west", north, west);
		}
		if (myDirect == east) {
			execution("east", south, east);
		}
	}
	
	private void execution(String directName, ReentrantLock firstLock, ReentrantLock secondLock) {
		try {
			firstLock.lockInterruptibly();
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			secondLock.lockInterruptibly();
			System.out.println("car to " + directName + " has passed");
		} catch (InterruptedException e1) {
			System.out.println("car to " + directName + " is killed");
		} finally {
			if (firstLock.isHeldByCurrentThread()) {
				firstLock.unlock();
			}
			if (secondLock.isHeldByCurrentThread()) {
				secondLock.unlock();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		DeadLockCar car2south = new DeadLockCar(south);
		DeadLockCar car2north = new DeadLockCar(north);
		DeadLockCar car2west = new DeadLockCar(west);
		DeadLockCar car2east = new DeadLockCar(east);
		car2south.start();
		car2north.start();
		car2west.start();
		car2east.start();
		Thread.sleep(5000);
		car2north.interrupt();//强行剥夺任意小车的资源，解除死锁。
	}
}
