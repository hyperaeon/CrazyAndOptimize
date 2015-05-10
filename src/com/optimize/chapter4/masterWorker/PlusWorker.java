package com.optimize.chapter4.masterWorker;

public class PlusWorker extends Worker {

	/* (non-Javadoc)
	 * @see com.optimize.chapter4.masterWorker.Worker#handle(java.lang.Object)
	 */
	@Override
	public Object handle(Object input) {
		Integer i = (Integer) input;
		return i * i * i;
	}

}
