package com.optimize.chapter4.guardedSuspension.future;

import com.optimize.chapter4.guardedSuspension.Data;
import com.optimize.chapter4.guardedSuspension.RealData;

public class FutureData implements Data {

	private boolean isReady;

	private RealData realData;

	/**
	 * @return the isReady
	 */
	public boolean isReady() {
		return isReady;
	}

	/**
	 * @param isReady
	 *            the isReady to set
	 */
	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}

	public void setRealData(RealData realData) {
		this.realData = realData;
	}

	@Override
	public String getContent() {
		return null;
	}

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return null;
	}
}
