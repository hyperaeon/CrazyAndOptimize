package com.optimize.chapter4.deadlock;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLockCar extends Thread {

	protected Object myDirect;

	static ReentrantLock south = new ReentrantLock();
	static ReentrantLock north = new ReentrantLock();
	static ReentrantLock east = new ReentrantLock();
	static ReentrantLock west = new ReentrantLock();

	public DeadLockCar(Object direct) {
		this.myDirect = direct;
		if (myDirect == south) {
			setName("south");
		}
		if (myDirect == north) {
			setName("north");
		}
		if (myDirect == east) {
			setName("east");
		}
		if (myDirect == west) {
			setName("west");
		}
	}

	public void run() {
		if (myDirect == south) {
			try {
				west.lockInterruptibly();
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				south.lockInterruptibly();
				System.out.println("cat to south has passed");
			} catch (InterruptedException e) {
				System.out.println("cat to south is killed");
			} finally {
				if (west.isHeldByCurrentThread()) {
					west.unlock();
				}
				if (south.isHeldByCurrentThread()) {
					south.unlock();
				}
			}
		}

		if (myDirect == north) {
			try {
				east.lockInterruptibly();
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				north.lockInterruptibly();
				System.out.println("cat to north has passed");
			} catch (InterruptedException e) {
				System.out.println("cat to north is killed");
			} finally {
				if (east.isHeldByCurrentThread()) {
					east.unlock();
				}
				if (north.isHeldByCurrentThread()) {
					north.unlock();
				}
			}
		}

		if (myDirect == east) {
			try {
				south.lockInterruptibly();
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				east.lockInterruptibly();
				System.out.println("cat to east has passed");
			} catch (InterruptedException e) {
				System.out.println("cat to east is killed");
			} finally {
				if (south.isHeldByCurrentThread()) {
					south.unlock();
				}
				if (east.isHeldByCurrentThread()) {
					east.unlock();
				}
			}
		}

		if (myDirect == west) {
			try {
				north.lockInterruptibly();
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				west.lockInterruptibly();
				System.out.println("cat to west has passed");
			} catch (InterruptedException e) {
				System.out.println("cat to west is killed");
			} finally {
				if (west.isHeldByCurrentThread()) {
					west.unlock();
				}
				if (north.isHeldByCurrentThread()) {
					north.unlock();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		DeadLockCar car2sourth = new DeadLockCar(south);
		DeadLockCar car2north = new DeadLockCar(north);
		DeadLockCar car2east = new DeadLockCar(east);
		DeadLockCar car2west = new DeadLockCar(west);
		car2sourth.start();
		car2north.start();
		car2east.start();
		car2west.start();
		Thread.sleep(1000);
		car2sourth.interrupt();
	}
}
