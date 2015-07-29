package com.optimize.chapter4.duplicate.future;

public class FutureData implements Data {

	protected boolean isReady = false;

	protected RealData realData = null;

	public synchronized void setRealData(RealData realData) {
		if (isReady) {
			return;
		}
		this.realData = realData;
		isReady = true;
		notifyAll();
	}

	@Override
	public synchronized String getResult() {
		while (!isReady) {
			try {
				wait();
			} catch (InterruptedException e) {
				
			}
		}
		return realData.result;
	}

}
