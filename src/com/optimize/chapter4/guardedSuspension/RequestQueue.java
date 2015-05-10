package com.optimize.chapter4.guardedSuspension;

import java.util.LinkedList;

public class RequestQueue {

	private LinkedList<Request> queue = new LinkedList<Request>();

	public synchronized Request getRequest() {
		while (queue.size() == 0) {
			try {
				wait();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		return (Request) queue.remove();
	}

	public synchronized void addRequest(Request request) {
		queue.add(request);
		notifyAll();
	}
}
