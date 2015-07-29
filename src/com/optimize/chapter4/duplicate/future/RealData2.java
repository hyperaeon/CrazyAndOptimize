package com.optimize.chapter4.duplicate.future;

import java.util.concurrent.Callable;

public class RealData2 implements Callable<String> {

	private String param;
	public RealData2(String param) {
		this.param = param;
	}
	
	@Override
	public String call() throws Exception {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			buffer.append(param);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return buffer.toString();
	}

}
